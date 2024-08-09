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
                jsonPath("chord.name") { value("C") }
            }
    }

    @Test
    fun `should return one chord major with plausibles others chords`() {
        mockMvc.get("$BASE_URL?notes=C,E,G")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("chord.name") { value("C") }
                jsonPath("otherPlausibleChords.size()") { value(3) }
                jsonPath("otherPlausibleChords[0].name") { value("C7") }
                jsonPath("otherPlausibleChords[1].name") { value("Cmaj7") }
                jsonPath("otherPlausibleChords[2].name") { value("Am7") }
            }
    }

    @Test
    fun `should return no exact chords and no plausible chords`() {
        mockMvc.get("$BASE_URL?notes=e,d,C")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("chord") { doesNotExist() }
                jsonPath("otherPlausibleChords.size()") { value(0) }
            }
    }

    @Test
    fun `should return an exact chord and no plausible chords when to specific`() {
        mockMvc.get("$BASE_URL?notes=C,E,G,Bb")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("chord.name") { value("C7") }
                jsonPath("otherPlausibleChords.size()") { value(0) }
            }
    }

    @Test
    fun `should return no exact chord but some plausible chords`() {
        mockMvc.get("$BASE_URL?notes=C,E")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("chord") { doesNotExist() }
                jsonPath("otherPlausibleChords.size()") { value(12) }
                jsonPath("otherPlausibleChords[0].name") { value("C") }
                jsonPath("otherPlausibleChords[1].name") { value("C7") }
                jsonPath("otherPlausibleChords[2].name") { value("Cmaj7") }
                jsonPath("otherPlausibleChords[3].name") { value("Caug") }
                jsonPath("otherPlausibleChords[4].name") { value("C#m(maj7)") }
                jsonPath("otherPlausibleChords[5].name") { value("Eaug") }
                jsonPath("otherPlausibleChords[6].name") { value("Fmaj7") }
                jsonPath("otherPlausibleChords[7].name") { value("Fm(maj7)") }
                jsonPath("otherPlausibleChords[8].name") { value("G#aug") }
                jsonPath("otherPlausibleChords[9].name") { value("Am") }
                jsonPath("otherPlausibleChords[10].name") { value("Am7") }
                jsonPath("otherPlausibleChords[11].name") { value("Am(maj7)") }

            }
    }

    @Test
    fun `should return one chord with s and b`() {
        mockMvc.get("$BASE_URL?notes=bb,Cs,F")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("chord.name") { value("Bbm") }
            }
    }

    @Test
    fun `should return one chord with #`() {
        mockMvc.get("$BASE_URL?notes={notes}", "a#,cs,f")

            .andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("chord.name") { value("Bbm") }
            }
    }

    @Test
    fun `error when input is not a valid not`() {
        mockMvc.get("$BASE_URL?notes=I,J,K").andDo { print() }.andExpect {
            status { isBadRequest() }
        }
    }
}


