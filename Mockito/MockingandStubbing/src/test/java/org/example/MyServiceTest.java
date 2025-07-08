package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;


public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Mock the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock into service
        MyService service = new MyService(mockApi);

        // Step 4: Call and assert
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}
