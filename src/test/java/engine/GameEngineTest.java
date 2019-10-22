package engine;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class GameEngineTest {

    GameEngine gameEngine = new GameEngine();

    @Test
    public void testGenerateDigit() {
        assertThat(gameEngine.generateDigit()).isBetween(0,10);
    }



}