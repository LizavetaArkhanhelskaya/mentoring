select id, name, surname 
from users where id in
    (
        select user_id
        from
            (
                select user_id1 as user_id, count(user_id1) as friends
                from  friendships
                group by user_id1
            )
        where friends > 10
    )
and id in
	(
		select user_id
		from posts
		where ID IN 
            (
                select post_id
                from
                    (
                        select post_id as post_id, count(post_id) as likes
                        from post_likes
                        where timestamp >= to_timestamp('01-03-2015 00:00:00', 'dd-mm-yyyy hh24:mi:ss')
                          and timestamp <= to_timestamp('31-03-2015 23:59:59', 'dd-mm-yyyy hh24:mi:ss')
                        group by post_id
                    )
                where likes > 10
            )
	)