package server.service

import org.springframework.web.multipart.MultipartFile

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

class FileUploader(private val file: MultipartFile, private val taskNumber: String) {

    fun upload(): Boolean {
        if (file.isEmpty) return false

        val bytes = file.bytes
        val uploadedFile = File("C:\\Projects\\Git\\trik-testsys\\tasks\\task" + taskNumber + "\\" + file.originalFilename)
        val stream = BufferedOutputStream(FileOutputStream(uploadedFile))

        stream.write(bytes)
        stream.close()

        return true
    }
}