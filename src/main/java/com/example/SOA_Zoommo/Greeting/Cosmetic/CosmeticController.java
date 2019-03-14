package com.example.SOA_Zoommo.Greeting.Cosmetic;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CosmeticController {

    List<Cosmetic> cosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("LIP001", "XOXO Lipstick", 1),
            new Cosmetic("BRO001", "NYX Brush On Palette", 1)
    ));

    @RequestMapping("/cosmetics")
    public List<Cosmetic> getAllCosmetics() {
        return cosmetics;
    }

    @RequestMapping("/cosemetic/{id}")
    public void deleteCosmetics(@PathVariable String id) {
        // วนลูปหาทุกๆตัวใน list cosmetics ของเรา
        for(int i = 0; i < cosmetics.size(); i++) {
            // ถ้า id ของ cosmetic index ที่ i มีค่าเท่ากับ id ที่ใส่เข้ามา
            if(cosmetics.get(i).getId().equals(id)) {
                // ลบทิ้ง และ ออกจากลูป
                cosmetics.remove(i);
                break;
            }
        }
    }

}
