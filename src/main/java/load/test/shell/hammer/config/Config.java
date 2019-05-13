package load.test.shell.hammer.config;

import load.test.shell.hammer.helper.RandomUserAgent;
import load.test.shell.hammer.thread.RequestThreadGroupRunner;
import load.test.shell.hammer.thread.RequestThreadGroupRunnersBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Configuration
public class Config {

    @Bean
    @Scope("singleton")
    public RandomUserAgent randomUserAgent(){
        return new RandomUserAgent();
    }

    @Bean
    @Scope("singleton")
    public RequestThreadGroupRunnersBuilder requestThreadGroupRunnersBuilder(){
        return new RequestThreadGroupRunnersBuilder(randomUserAgent());
    }

    @Bean("threadGroupesReference")
    @Scope("singleton")
    public AtomicReference<List<RequestThreadGroupRunner>> threadGroupesReference(){
        return new AtomicReference<>();
    }
}
