package com.hq.koneko.myapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by k-inaba on 2018/10/06.
 */

public class Store {
    private static Store _ins = new Store();

    private Store() {
        this.createTestData2();
    }

    public ArrayList<ArticleData> Data;

    public static Store getInstance() {
        return _ins;
    }

    public void add(ArticleData dd) {
        this.Data.add(dd);
    }

    private void createTestData2() {
        try {
            this.createMockData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<ArticleData> list = new ArrayList<ArticleData>();

        int index = 1;
        for (ArticleData d: this.mockData) {
            ArticleData x = d;
            x.setId("" + index);

            list.add(x);
        }
        this.Data = list;
    }

    private ArrayList<ArticleData> mockData = new ArrayList<>();

    private void createMockData() throws ParseException {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        this.mockData.add(
            new ArticleData("",
                    "“Take One for the Team!” Individual Heterogeneity and the Emergence of Latent Norms in a Volunteer’s Dilemma",
                    "A Diekmann",
                    "Social Forces, Volume 94, Issue 3",
                    fmt.parse("2013/03/01"),
                    3,
                    "The tension between individual and collective interests and the provision of sanc-tioning mechanisms have been identified as important building blocks of a theory of norm emergence. Correspondingly, most investigations focus on how social norms emerge through explicit bargaining and social exchange to overcome this ten-sion, and how sanctions enforce norm compliance. However, sanctioning presupposes the existence of the behavior at which it is directed, and the question of how behavior worth  sanctioning  can  emerge  tacitly  if  communication  is  not  possible  has  hitherto  received little attention. Here, we argue that game theory offers an ideal framework for theorizing  about  emergent  behavioral  regularities  and  show  how  latent  norms  can  emerge from actors’ recurring encounters in similar social dilemmas. We conduct two experiments  in  which  small  groups  of  subjects  interact  repeatedly  in  a  volunteer’s  dilemma. We vary the heterogeneity of group members in terms of their costs of coop-eration and the way they encounter each other in subsequent interactions. Our results show that subjects in homogeneous groups take turns at cooperating, whereas in het-erogeneous groups mostly the subjects with the lowest costs cooperate. The emer-gence of solitary cooperation is moderated by the way subjects encounter each other again and their other-regarding preferences.",
                    11,
                    "評価方法が参考になる。結果については関係性が低い",
                    null));
        this.mockData.add(
                    new ArticleData("",
                            "Volunteer's Dilemma",
                            "A Diekmann",
                            "Journal of conflict resolution",
                            fmt.parse("1985/12/01"),
                            4,
                            "A conflict game simulating social traps in which a collective good can be provided by a volunteer is discussed and some solution concepts are analyzed. There is a greater incentive for “free riding” than for the production of the collective good at the cost of the volunteer. However, if everybody defects, all players will lose. Such a result is frequently produced by “diffusion of responsibility” as described by Darley and Latané (1968). In contrast to other social traps, a dominant strategy does not exist. Also, the mixed-equilibrium strategy yields very low payoffs. The expected gain is not greater than the payoff achieved by the nonequilibrium maximum strategy. Superrationality might be a way out of the trap. However, this concept lacks the desirable equilibrium property. Only in the free communication version of the game can a definitive answer to the question of a rational strategy be given.",
                            442,
                            "有用",
                            null));

        this.mockData.add(
                new ArticleData("",
                        "More than words: the effects of cheap talkin a volunteer’s dilemma",
                        "Christoph Feldhaus, Julia Stauf",
                        "Economic Science Association",
                        fmt.parse("2015/05/09"),
                        4,
                        "We theoretically and experimentally investigate a game in which ex-actly one person should make a costly effort to achieve a socially efficient outcome.This setting is commonly known as the volunteer’s dilemma. We implement one-way communication by allowing one player to send a message indicating whethershe intends to volunteer and investigate the message’s effects on behavior andefficiency in the subsequent game. We theoretically demonstrate that there areasymmetric mixed-strategy equilibria in the volunteer’s dilemma and argue that oneof these is likely to emerge through one-way communication. The experimental datasupport this notion. We find that the actions of both the sender and receiver of themessage are crucially affected by the cheap talk stage and that efficiency in thevolunteer’s dilemma increases with one-way communication.",
                        140,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "An experimental examination of the volunteer's dilemma",
                        "JacobK. Goeree, Charles A. Holt, AngelaM. Smith",
                        "Games and Economic Behavior Volume 102, March 2017, Pages 303-315",
                        fmt.parse("2015/7/12"),
                        4,
                        "In a volunteer's dilemma, only one “volunteer” is needed to obtain a benefit for all. Volunteering is costly, and the symmetric Nash equilibrium involves randomization. These predictions have the intuitive property that volunteer rates decline with larger groups, but surprisingly, the probability of obtaining no volunteers is increasing with group size, even as the number of players goes to infinity. These predictions are evaluated in a laboratory experiment with a range of group sizes. Observed volunteer rates are lower with larger groups, as predicted, but the incidence of no-volunteer outcomes declines with group size, in contrast to theory. This reduction in no-volunteer outcomes for large groups can be explained by a one-parameter generalization of the Nash equilibrium that adds quantal response “noise” due to unobserved random effects. Significant individual heterogeneity in observed volunteer rates motivates the estimation of a heterogeneous equilibrium model with a distribution of propensities for volunteering.",
                        45,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Rational cooperation in the finitely repeated prisoners' dilemma",
                        "David MKrepsPaulMilgromJohnRobertsRobertWilson",
                        "Journal of Economic Theory Volume 27, Issue 2, August 1982, Pages 245-252",
                        fmt.parse("1982/01/01"),
                        4,
                        "A common observation in experiments involving finite repetition of the prisoners' dilemma is that players do not always play the single-period dominant strategies (“finking”), but instead achieve some measure of cooperation. Yet finking at each stage is the only Nash equilibrium in the finitely repeated game. We show here how incomplete information about one or both players' options, motivation or behavior can explain the observed cooperation. Specifically, we provide a bound on the number of rounds at which Fink may be played, when one player may possibly be committed to a “Tit-for-Tat” strategy.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Exploitation, Exploration, and Process Management: The Productivity Dilemma Revisited",
                        "Mary J. Benner and Michael L. Tushman",
                        "Academy of Management ReviewVol. 28, No. 2",
                        fmt.parse("2003/12/01"),
                        4,
                        "We develop a contingency view of process management's influence on both technological innovation and organizational adaptation. We argue that while process management activities are beneficial for organizations in stable contexts, they are fundamentally inconsistent with all but incremental innovation and change. But dynamic capabilities are rooted in both exploitative and exploratory activities. We argue that process management activities must be buffered from exploratory activities and that ambidextrous organizational forms provide the complex contexts for these inconsistent activities to coexist.",
                        4007,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Neural networks and the bias/variance dilemma",
                        "S Geman, E Bienenstock, R Doursat ",
                        "Neural computation",
                        fmt.parse("1992/12/01"),
                        4,
                        "Feedforward neural networks trained by error backpropagation are examples of nonparametric regression estimators. We present a tutorial on nonparametric inference and its relation to neural networks, and we use the statistical viewpoint to highlight strengths and weaknesses of neural models. We illustrate the main points with some recognition experiments involving artificial data as well as handwritten numerals. In way of conclusion, we suggest that current-generation feedforward neural networks are largely inadequate for difficult problems in machine perception and machine learning, regardless of parallel-versus-serial hardware or other implementation issues. Furthermore, we suggest that the fundamental challenges in neural modeling are about representation rather than learning per se. This last point is supported by additional experiments with handwritten numerals.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Evolutionary prisoner's dilemma game on a square lattice",
                        "G Szabó, C Tőke",
                        "Physical Review E",
                        fmt.parse("1998/12/01"),
                        4,
                        "",
                        969,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "“Take One for the Team!” Individual Heterogeneity and the Emergence of Latent Norms in a Volunteer’s Dilemma",
                        "A Diekmann",
                        "Social Forces, Volume 94, Issue 3",
                        fmt.parse("2013/03/01"),
                        3,
                        "The tension between individual and collective interests and the provision of sanc-tioning mechanisms have been identified as important building blocks of a theory of norm emergence. Correspondingly, most investigations focus on how social norms emerge through explicit bargaining and social exchange to overcome this ten-sion, and how sanctions enforce norm compliance. However, sanctioning presupposes the existence of the behavior at which it is directed, and the question of how behavior worth  sanctioning  can  emerge  tacitly  if  communication  is  not  possible  has  hitherto  received little attention. Here, we argue that game theory offers an ideal framework for theorizing  about  emergent  behavioral  regularities  and  show  how  latent  norms  can  emerge from actors’ recurring encounters in similar social dilemmas. We conduct two experiments  in  which  small  groups  of  subjects  interact  repeatedly  in  a  volunteer’s  dilemma. We vary the heterogeneity of group members in terms of their costs of coop-eration and the way they encounter each other in subsequent interactions. Our results show that subjects in homogeneous groups take turns at cooperating, whereas in het-erogeneous groups mostly the subjects with the lowest costs cooperate. The emer-gence of solitary cooperation is moderated by the way subjects encounter each other again and their other-regarding preferences.",
                        11,
                        "",
                        null));
        this.mockData.add(
                new ArticleData("",
                        "Volunteer's Dilemma",
                        "A Diekmann",
                        "Journal of conflict resolution",
                        fmt.parse("1985/12/01"),
                        4,
                        "A conflict game simulating social traps in which a collective good can be provided by a volunteer is discussed and some solution concepts are analyzed. There is a greater incentive for “free riding” than for the production of the collective good at the cost of the volunteer. However, if everybody defects, all players will lose. Such a result is frequently produced by “diffusion of responsibility” as described by Darley and Latané (1968). In contrast to other social traps, a dominant strategy does not exist. Also, the mixed-equilibrium strategy yields very low payoffs. The expected gain is not greater than the payoff achieved by the nonequilibrium maximum strategy. Superrationality might be a way out of the trap. However, this concept lacks the desirable equilibrium property. Only in the free communication version of the game can a definitive answer to the question of a rational strategy be given.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "More than words: the effects of cheap talkin a volunteer’s dilemma",
                        "Christoph Feldhaus, Julia Stauf",
                        "Economic Science Association",
                        fmt.parse("2015/05/09"),
                        4,
                        "We theoretically and experimentally investigate a game in which ex-actly one person should make a costly effort to achieve a socially efficient outcome.This setting is commonly known as the volunteer’s dilemma. We implement one-way communication by allowing one player to send a message indicating whethershe intends to volunteer and investigate the message’s effects on behavior andefficiency in the subsequent game. We theoretically demonstrate that there areasymmetric mixed-strategy equilibria in the volunteer’s dilemma and argue that oneof these is likely to emerge through one-way communication. The experimental datasupport this notion. We find that the actions of both the sender and receiver of themessage are crucially affected by the cheap talk stage and that efficiency in thevolunteer’s dilemma increases with one-way communication.",
                        140,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "An experimental examination of the volunteer's dilemma",
                        "JacobK. Goeree, Charles A. Holt, AngelaM. Smith",
                        "Games and Economic Behavior Volume 102, March 2017, Pages 303-315",
                        fmt.parse("2015/7/12"),
                        4,
                        "In a volunteer's dilemma, only one “volunteer” is needed to obtain a benefit for all. Volunteering is costly, and the symmetric Nash equilibrium involves randomization. These predictions have the intuitive property that volunteer rates decline with larger groups, but surprisingly, the probability of obtaining no volunteers is increasing with group size, even as the number of players goes to infinity. These predictions are evaluated in a laboratory experiment with a range of group sizes. Observed volunteer rates are lower with larger groups, as predicted, but the incidence of no-volunteer outcomes declines with group size, in contrast to theory. This reduction in no-volunteer outcomes for large groups can be explained by a one-parameter generalization of the Nash equilibrium that adds quantal response “noise” due to unobserved random effects. Significant individual heterogeneity in observed volunteer rates motivates the estimation of a heterogeneous equilibrium model with a distribution of propensities for volunteering.",
                        45,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Rational cooperation in the finitely repeated prisoners' dilemma",
                        "David MKrepsPaulMilgromJohnRobertsRobertWilson",
                        "Journal of Economic Theory Volume 27, Issue 2, August 1982, Pages 245-252",
                        fmt.parse("1982/01/01"),
                        4,
                        "A common observation in experiments involving finite repetition of the prisoners' dilemma is that players do not always play the single-period dominant strategies (“finking”), but instead achieve some measure of cooperation. Yet finking at each stage is the only Nash equilibrium in the finitely repeated game. We show here how incomplete information about one or both players' options, motivation or behavior can explain the observed cooperation. Specifically, we provide a bound on the number of rounds at which Fink may be played, when one player may possibly be committed to a “Tit-for-Tat” strategy.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Exploitation, Exploration, and Process Management: The Productivity Dilemma Revisited",
                        "Mary J. Benner and Michael L. Tushman",
                        "Academy of Management ReviewVol. 28, No. 2",
                        fmt.parse("2003/12/01"),
                        4,
                        "We develop a contingency view of process management's influence on both technological innovation and organizational adaptation. We argue that while process management activities are beneficial for organizations in stable contexts, they are fundamentally inconsistent with all but incremental innovation and change. But dynamic capabilities are rooted in both exploitative and exploratory activities. We argue that process management activities must be buffered from exploratory activities and that ambidextrous organizational forms provide the complex contexts for these inconsistent activities to coexist.",
                        4007,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Neural networks and the bias/variance dilemma",
                        "S Geman, E Bienenstock, R Doursat ",
                        "Neural computation",
                        fmt.parse("1992/12/01"),
                        4,
                        "Feedforward neural networks trained by error backpropagation are examples of nonparametric regression estimators. We present a tutorial on nonparametric inference and its relation to neural networks, and we use the statistical viewpoint to highlight strengths and weaknesses of neural models. We illustrate the main points with some recognition experiments involving artificial data as well as handwritten numerals. In way of conclusion, we suggest that current-generation feedforward neural networks are largely inadequate for difficult problems in machine perception and machine learning, regardless of parallel-versus-serial hardware or other implementation issues. Furthermore, we suggest that the fundamental challenges in neural modeling are about representation rather than learning per se. This last point is supported by additional experiments with handwritten numerals.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Evolutionary prisoner's dilemma game on a square lattice",
                        "G Szabó, C Tőke",
                        "Physical Review E",
                        fmt.parse("1998/12/01"),
                        4,
                        "",
                        969,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "“Take One for the Team!” Individual Heterogeneity and the Emergence of Latent Norms in a Volunteer’s Dilemma",
                        "A Diekmann",
                        "Social Forces, Volume 94, Issue 3",
                        fmt.parse("2013/03/01"),
                        3,
                        "The tension between individual and collective interests and the provision of sanc-tioning mechanisms have been identified as important building blocks of a theory of norm emergence. Correspondingly, most investigations focus on how social norms emerge through explicit bargaining and social exchange to overcome this ten-sion, and how sanctions enforce norm compliance. However, sanctioning presupposes the existence of the behavior at which it is directed, and the question of how behavior worth  sanctioning  can  emerge  tacitly  if  communication  is  not  possible  has  hitherto  received little attention. Here, we argue that game theory offers an ideal framework for theorizing  about  emergent  behavioral  regularities  and  show  how  latent  norms  can  emerge from actors’ recurring encounters in similar social dilemmas. We conduct two experiments  in  which  small  groups  of  subjects  interact  repeatedly  in  a  volunteer’s  dilemma. We vary the heterogeneity of group members in terms of their costs of coop-eration and the way they encounter each other in subsequent interactions. Our results show that subjects in homogeneous groups take turns at cooperating, whereas in het-erogeneous groups mostly the subjects with the lowest costs cooperate. The emer-gence of solitary cooperation is moderated by the way subjects encounter each other again and their other-regarding preferences.",
                        11,
                        "",
                        null));
        this.mockData.add(
                new ArticleData("",
                        "Volunteer's Dilemma",
                        "A Diekmann",
                        "Journal of conflict resolution",
                        fmt.parse("1985/12/01"),
                        4,
                        "A conflict game simulating social traps in which a collective good can be provided by a volunteer is discussed and some solution concepts are analyzed. There is a greater incentive for “free riding” than for the production of the collective good at the cost of the volunteer. However, if everybody defects, all players will lose. Such a result is frequently produced by “diffusion of responsibility” as described by Darley and Latané (1968). In contrast to other social traps, a dominant strategy does not exist. Also, the mixed-equilibrium strategy yields very low payoffs. The expected gain is not greater than the payoff achieved by the nonequilibrium maximum strategy. Superrationality might be a way out of the trap. However, this concept lacks the desirable equilibrium property. Only in the free communication version of the game can a definitive answer to the question of a rational strategy be given.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "More than words: the effects of cheap talkin a volunteer’s dilemma",
                        "Christoph Feldhaus, Julia Stauf",
                        "Economic Science Association",
                        fmt.parse("2015/05/09"),
                        4,
                        "We theoretically and experimentally investigate a game in which ex-actly one person should make a costly effort to achieve a socially efficient outcome.This setting is commonly known as the volunteer’s dilemma. We implement one-way communication by allowing one player to send a message indicating whethershe intends to volunteer and investigate the message’s effects on behavior andefficiency in the subsequent game. We theoretically demonstrate that there areasymmetric mixed-strategy equilibria in the volunteer’s dilemma and argue that oneof these is likely to emerge through one-way communication. The experimental datasupport this notion. We find that the actions of both the sender and receiver of themessage are crucially affected by the cheap talk stage and that efficiency in thevolunteer’s dilemma increases with one-way communication.",
                        140,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "An experimental examination of the volunteer's dilemma",
                        "JacobK. Goeree, Charles A. Holt, AngelaM. Smith",
                        "Games and Economic Behavior Volume 102, March 2017, Pages 303-315",
                        fmt.parse("2015/7/12"),
                        4,
                        "In a volunteer's dilemma, only one “volunteer” is needed to obtain a benefit for all. Volunteering is costly, and the symmetric Nash equilibrium involves randomization. These predictions have the intuitive property that volunteer rates decline with larger groups, but surprisingly, the probability of obtaining no volunteers is increasing with group size, even as the number of players goes to infinity. These predictions are evaluated in a laboratory experiment with a range of group sizes. Observed volunteer rates are lower with larger groups, as predicted, but the incidence of no-volunteer outcomes declines with group size, in contrast to theory. This reduction in no-volunteer outcomes for large groups can be explained by a one-parameter generalization of the Nash equilibrium that adds quantal response “noise” due to unobserved random effects. Significant individual heterogeneity in observed volunteer rates motivates the estimation of a heterogeneous equilibrium model with a distribution of propensities for volunteering.",
                        45,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Rational cooperation in the finitely repeated prisoners' dilemma",
                        "David MKrepsPaulMilgromJohnRobertsRobertWilson",
                        "Journal of Economic Theory Volume 27, Issue 2, August 1982, Pages 245-252",
                        fmt.parse("1982/01/01"),
                        4,
                        "A common observation in experiments involving finite repetition of the prisoners' dilemma is that players do not always play the single-period dominant strategies (“finking”), but instead achieve some measure of cooperation. Yet finking at each stage is the only Nash equilibrium in the finitely repeated game. We show here how incomplete information about one or both players' options, motivation or behavior can explain the observed cooperation. Specifically, we provide a bound on the number of rounds at which Fink may be played, when one player may possibly be committed to a “Tit-for-Tat” strategy.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Exploitation, Exploration, and Process Management: The Productivity Dilemma Revisited",
                        "Mary J. Benner and Michael L. Tushman",
                        "Academy of Management ReviewVol. 28, No. 2",
                        fmt.parse("2003/12/01"),
                        4,
                        "We develop a contingency view of process management's influence on both technological innovation and organizational adaptation. We argue that while process management activities are beneficial for organizations in stable contexts, they are fundamentally inconsistent with all but incremental innovation and change. But dynamic capabilities are rooted in both exploitative and exploratory activities. We argue that process management activities must be buffered from exploratory activities and that ambidextrous organizational forms provide the complex contexts for these inconsistent activities to coexist.",
                        4007,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Neural networks and the bias/variance dilemma",
                        "S Geman, E Bienenstock, R Doursat ",
                        "Neural computation",
                        fmt.parse("1992/12/01"),
                        4,
                        "Feedforward neural networks trained by error backpropagation are examples of nonparametric regression estimators. We present a tutorial on nonparametric inference and its relation to neural networks, and we use the statistical viewpoint to highlight strengths and weaknesses of neural models. We illustrate the main points with some recognition experiments involving artificial data as well as handwritten numerals. In way of conclusion, we suggest that current-generation feedforward neural networks are largely inadequate for difficult problems in machine perception and machine learning, regardless of parallel-versus-serial hardware or other implementation issues. Furthermore, we suggest that the fundamental challenges in neural modeling are about representation rather than learning per se. This last point is supported by additional experiments with handwritten numerals.",
                        442,
                        "",
                        null));

        this.mockData.add(
                new ArticleData("",
                        "Evolutionary prisoner's dilemma game on a square lattice",
                        "G Szabó, C Tőke",
                        "Physical Review E",
                        fmt.parse("1998/12/01"),
                        4,
                        "",
                        969,
                        "",
                        null));
        /*

        this.mockData.add(
                new ArticleData("",
                        "",
                        "",
                        "",
                        fmt.parse("1985/12/01"),
                        4,
                        "",
                        442,
                        "",
                        null));


         */

    }

}
