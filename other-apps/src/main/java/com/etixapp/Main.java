package com.etixapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Your IP's are:");
        System.out.println(GetLocalIp.getLocalIp());
        System.out.println(GetLocalIp.getLocalIpV2());
        System.out.println(GetPublicIp.getPublicIpAddress());
        System.out.println(GetPublicIp.getPublicIpListAddress().toString());

    }


    public static class GetLocalIp {
        public static String getLocalIp() {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("google.com", 80));
                //other way
                InetAddress IP = InetAddress.getLocalHost();
                System.out.println(IP.toString());
                return socket.getLocalAddress().getHostAddress();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String getLocalIpV2() throws SocketException {
            try (final DatagramSocket datagramSocket = new DatagramSocket()) {
                datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 12345);
                return datagramSocket.getLocalAddress().getHostAddress();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static class GetPublicIp {
        static String urlString = "http://checkip.amazonaws.com/";
        static List<String> urlStringList = Arrays.asList(new String[]{
                "http://checkip.amazonaws.com/",
                "https://ipv4.icanhazip.com/",
                "http://myexternalip.com/raw",
                "http://ipecho.net/plain"
        });
        static URL url;

        static {
            try {
                url = new URL(urlString);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        public GetPublicIp() throws MalformedURLException {
        }

        public static String getPublicIpAddress() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                return br.readLine();
            } catch (Exception e) {
                throw e;
            }
        }


        public static List<String> getPublicIpListAddress() throws IOException {

            List<String> ipStringList = new ArrayList<>();
            List<URL> URLasList = getURLasList();

            URLasList.forEach(u -> {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    ipStringList.add(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            return ipStringList;
        }

        private static List<URL> getURLasList() {

            List<URL> URLasList = new ArrayList<>();

            urlStringList.forEach(urlString -> {
                try {
                    URL urlObj = new URL(urlString);
                    URLasList.add(urlObj);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            });

            return URLasList;
        }

    }
}