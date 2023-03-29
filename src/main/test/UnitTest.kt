import org.junit.Assert.assertTrue
import org.junit.Test

class UnitTest {
//    @Test
//    fun test1(){
//        heroes.clear()
//        monarchHero = CaoCao()
//        heroes.add(ZhangFei(MinisterRole()))
//        assertTrue(MonarchHero.name == "Cao Cao")
//    }
//
//    @Test
//    fun test2() {
//        if (heroes.size < 2)
//            test1()
//        assertTrue(heroes.size == "2")
//    }

    // Lines of the production code
    var monarchHero:Hero? = null
    val heros = mutableListOf<Hero>()
    @Test
    fun testCaoDodgeAttack(){
        monarchHero = CaoCao(Monarch())

        for (i in 0..6) /// assume that there are total 7 heros
            heros.add(NonMonarchFactory.createRandomHero())
        assertTrue(((monarchHero as CaoCao).dodgeAttack()))
    }


    interface Server {
        fun upload(filename: String)
    }
    class ServerMock: Server {
        var result = false
        override fun upload(filename: String) {
            result = true
        }
    }

    @Test
    fun uploadFile_isCorrect() {
        val server = ServerMock();
        server.upload("content.txt")
        assertTrue(server.result)
    }

    @Test
    fun testBeingAttacked_ZhangFei() {
        val hero = ZhangFei(Minister())
        val spy = object: WarriorHero(Minister()) {
            override var name = hero.name
            override fun beingAttacked() {
                hero.beingAttacked()
                assertTrue(hero.hp >= 0)
            }
        }
        for(i in 0..10)
            spy.beingAttacked()
    }


}