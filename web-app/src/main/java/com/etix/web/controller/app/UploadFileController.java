package com.etix.web.controller.app;

import com.etix.web.model.UploadFileModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RestController
@RequestMapping("/api/file")
//@CrossOrigin("http://localhost:4200")
//@CrossOrigin
public class UploadFileController {



    @PostMapping("/image")
    public ResponseEntity saveFile(@RequestBody UploadFileModel data,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity("PING", HttpStatus.OK);
    }


//    @ApiResponse(
//            responseCode = "201",
//            description = "Created",
//            content = @Content(schema = @Schema(implementation = UploadFileModel.class)))
//    @PostMapping(value = "/tenants/{tenant-key}/vehicles/{vin}/flash")
//    @io.swagger.v3.oas.annotations.parameters.RequestBody(
//            required = true,
//            content =
//            @Content(
//                    mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE,
//                    schema = @Schema(type = "string", format = "binary")))
//    @Operation(
//            operationId = "CreateFlashEcuReadout",
//            summary = "Trigger Flash Ecu readout for a device")
//    public Optional<UploadFileModel> triggerNewReadout(
//            @PathVariable(name = "tenant-key") String tenant,
//            @PathVariable(name = "vin") String vin,
//            @RequestParam(name = "device") String device,
//            @RequestParam(name = "flash-session") String flashSession,
//            @RequestHeader(name = "file-date") String fileDate,
//            @RequestHeader(name = "file-name") String fileName,
//            InputStream file)
//            throws IOException {
//        return null;
//    }

}
