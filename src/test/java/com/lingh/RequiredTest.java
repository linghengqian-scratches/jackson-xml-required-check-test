package com.lingh;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequiredTest {
    @Test
    void assertRequiredValue() {
        ObjectMapper XML_MAPPER = XmlMapper.builder().build();
        assertThrows(MismatchedInputException.class, () -> XML_MAPPER.readValue("<Record></Record>", TestRecord.class));
        assertThrows(MismatchedInputException.class, () -> XML_MAPPER.readValue("<TR></TR>", TestRecordWithoutCreator.class));
    }

    @Getter
    @NoArgsConstructor
    @JacksonXmlRootElement(localName = "Record")
    static class TestRecord {
        private String type;

        private String driverClassName;

        @JsonCreator
        public TestRecord(
                @JsonProperty(required = true) @JacksonXmlProperty(localName = "type", isAttribute = true)
                String type,
                @JsonProperty(required = true) @JacksonXmlProperty(localName = "driverClassName")
                String driverClassName) {
            this.type = type;
            this.driverClassName = driverClassName;
        }
    }

    @Getter
    @JacksonXmlRootElement(localName = "TR")
    static class TestRecordWithoutCreator {
        @JsonProperty(required = true)
        @JacksonXmlProperty(localName = "type", isAttribute = true)
        private String type;

        @JsonProperty(required = true)
        @JacksonXmlProperty(localName = "driverClassName")
        private String driverClassName;
    }
}
