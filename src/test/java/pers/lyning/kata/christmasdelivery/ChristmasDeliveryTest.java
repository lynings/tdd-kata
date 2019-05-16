package pers.lyning.kata.christmasdelivery;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ChristmasDeliveryTest {

//    @Test
    public void acceptance_test() {
        // given
        /* 雪橇 */
        SantasSleigh santasSleigh = new ConcreteSantasSleigh();
        /* 礼物投递者，投递到雪橇 */
        List<Deliverer> presentDeliverers = Lists.newArrayList(
                new PresentDeliverer("精灵1"),
                new PresentDeliverer("精灵2"),
                new PresentDeliverer("精灵3")
        );
        /* 礼物表单，用于确定哪些礼物属于哪个家庭，就可以把同一家庭的礼物挨个派发给 deliverer */
        List<PresentForm> presentForms = Lists.list(
                PresentForm.create(Presents.chain().A().and().B().and().B().end(), Destination.A()),
                PresentForm.create(Presents.chain().A().and().B().and().B().end(), Destination.B()),
                PresentForm.create(Presents.chain().A().and().B().and().B().end(), Destination.C()),
                PresentForm.cancel(Presents.chain().A().and().B().and().B().end(), Destination.D())

        );
        /* 控制器 */
        ChristmasDelivery christmasDelivery = new ChristmasDelivery(presentForms, presentDeliverers);
        // when
        List<PresentForm> forms = christmasDelivery.packTo(santasSleigh).getPresentForms();
        // then
        List<PresentForm> givenPresents = Lists.list(
                PresentForm.create(Presents.chain().A().and().B().and().B().end(), Destination.A()),
                PresentForm.create(Presents.chain().A().and().B().and().B().end(), Destination.B()),
                PresentForm.create(Presents.chain().A().and().B().and().B().end(), Destination.C())
        );
        assertThat(forms).isEqualTo(givenPresents);
    }
}
