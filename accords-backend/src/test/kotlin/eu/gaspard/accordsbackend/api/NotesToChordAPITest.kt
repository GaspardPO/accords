package eu.gaspard.accordsbackend.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class NotesToChordAPITest @Autowired constructor(val mockMvc: MockMvc) {


    private val BASE_URL = "/api/notesToChord"

    @Test
    fun `should return one chord major`() {
        mockMvc.get("$BASE_URL?notes=C,E,G")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("name") { value("C") }
            }
    }

    @Test
    fun `should return one chord minor`() {
        mockMvc.get("$BASE_URL?notes=A,C,E")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("name") { value("Am") }
            }
    }

    @Test
    fun `should return one chord with s and b`() {
        mockMvc.get("$BASE_URL?notes=bb,Cs,F")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("name") { value("A#m") }
            }
    }

     @Test
    fun `error when input is not a valid not`() {
        mockMvc.get("$BASE_URL?notes=I,J,K")
            .andDo { print() }.andExpect {
                status { isBadRequest() }
            }
    }
}


