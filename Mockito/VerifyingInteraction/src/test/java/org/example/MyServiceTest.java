package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Create service using the mock
        MyService service = new MyService(mockApi);

        // Step 3: Call the method that should invoke mockApi.getData()
        service.fetchData();

        // Step 4: Verify that mockApi.getData() was called exactly once
        verify(mockApi).getData();
    }
}
