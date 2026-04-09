package barker_server.adapter.in.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping("/memory")
    public Map<String, Long> getMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();

        Map<String, Long> memory = new HashMap<>();
        memory.put("totalMemory", runtime.totalMemory() / 1024 / 1024); // MB
        memory.put("freeMemory", runtime.freeMemory() / 1024 / 1024);
        memory.put("usedMemory", (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024);
        memory.put("maxMemory", runtime.maxMemory() / 1024 / 1024);

        return memory;
    }
}