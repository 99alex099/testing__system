CREATE PROCEDURE `calculate_percent_correct_answers`(
    IN selectedUserId int,
    IN selectedQuestionId int
)
BEGIN

    drop table if exists rating_tmp;
    create temporary table rating_tmp (
                                          `questionId` int unsigned,
                                          `description` varchar(128),
                                          `correctAns` int unsigned,
                                          `allAns` int unsigned
    );

    insert into rating_tmp (questionId, description, correctAns, allAns)
        (SELECT st.questionId, q.description, SUM(correct) AS 'correctAns', COUNT(correct) AS 'allAns'
         FROM statistics st
                  JOIN questions q ON st.questionId = q.questionId
         WHERE st.userId = selectedUserId
         GROUP BY st.questionId);

    SELECT correctAns/allAns*100 FROM rating_tmp gs
    WHERE gs.questionId = selectedQuestionId;
END