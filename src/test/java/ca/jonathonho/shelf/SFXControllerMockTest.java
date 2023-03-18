package ca.jonathonho.shelf;

import ca.jonathonho.shelf.controller.SFXController;
import ca.jonathonho.shelf.service.SFXService;
import ca.jonathonho.shelf.model.SFX;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(SFXController.class)
public class SFXControllerMockTest {
  
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SFXService service;

  /**
   * Test that the SFXController returns a 200 status code when the /api/sfx
   * @throws Exception
   * 
   */
  @Test
  public void getSfxShouldReturnAllSfx() throws Exception {
    when(service.getAllSFX()).thenReturn(new ArrayList<SFX>());
    this.mockMvc.perform(get("/api/sfx")).andExpect(status().isOk());
  }

  /**
   * Test that the SFXController returns a 200 status code when the /api/sfx/1
   * @throws Exception
   */
  @Test
  public void getSfxByIdShouldReturnSfx() throws Exception {
    when(service.getSFXById((long)1)).thenReturn(new SFX(1, "testSfx"));
    this.mockMvc.perform(get("/api/sfx/1")).andExpect(status().isOk())
      .andExpect(content().string(containsString("testSfx")));
  }

  /**
   * Test that the SFXController returns a 200 status code when the /api/sfx/1
   * @throws Exception
   */
  @Test
  public void getSfxByIdShouldReturnNull() throws Exception {
    when(service.getSFXById((long)1)).thenReturn(null);
    this.mockMvc.perform(get("/api/sfx/1")).andExpect(status().isOk())
    .andExpect(content().string(containsString("")));
  }

  /**
   * Test that the SFXController returns a 200 status code when the /api/sfx/1
   * @throws Exception
   */
  @Test
  public void searchGetsNoEntries() throws Exception {
    SFX sfx = new SFX(1, "testSfx");
    ArrayList<SFX> sfxList = new ArrayList<SFX>();
    sfxList.add(sfx);
    when(service.searchSFX("もぐもぐ")).thenReturn(sfxList);
    this.mockMvc.perform(get("/api/sfx/search?query=もぐもぐ")).andExpect(status().isOk())
      .andExpect(content().string(containsString("[]")));
  }

    /**
   * Test that the SFXController returns a 200 status code when the /api/sfx/1
   * @throws Exception
   */
  @Test
  public void searchGetsManyEntries() throws Exception {
    ArrayList<SFX> sfxList = new ArrayList<SFX>();
    for (int i = 0; i < 100; i++) {
      SFX sfx = new SFX(i, String.valueOf(i).concat("testSfx"));
      sfxList.add(sfx);
    }
    when(service.searchSFX("testSfx")).thenReturn(sfxList);
    this.mockMvc.perform(get("/api/sfx/search?query=testSfx")).andExpect(status().isOk())
      .andExpect(content().string(containsString("testSfx")));
  }
}

