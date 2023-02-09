use HappyFields;

insert into utente values
('annac01', 'Annachiara', 'NA', 'saviano', 'v.gemito', 3289018431, 'IT99C1234567689012345678902', 'calcio'),
('genn09', 'calcare00', 'NA', 'san paolo', 'vincenzo gemito', 3289876431, 'IT99C1987654329012345678902', 'tennis'),
('mariolino', 'bradipi99', 'SA', 'mercato san severino', 'cirtcumvallazione', 3299918431, 'IT89S1234567689012345678902', 'basket'),
('armandino88', 'patatiness', 'SA', 'baronissi', 'vittorio emanuele', 3275432201, 'IT01C789654389012345678902', 'calcio'),
('cucciolone70', 'mammaaaaaaaa', 'SA', 'baronissi', 'vittorio emanuele', 3256784431, 'IT01C9987765543321166778654', 'paddle'),
('armandino88', 'giornataccia', 'AV', 'avellino', 'san sebastiano', 3456789011, 'IT01C000099889012345678902', 'pallavolo'),
('beatrice69', 'bestiolinabbb', 'SA', 'baronissi', 'vittorio emanuele', 3987654321, 'IT01C789654389010000000099', 'tennis'),
('carlino01', 'occhialidasole', 'SA', 'mercato s.severino', 'circumvallazione', 3289007864, 'IT01C789654389019090909090', 'calcetto'),
('matti01', 'monellone', 'SA', 'baronissi', 'vittorio emanuele', 3289099999, 'IT01S709876767662345678902', 'tennis'),
('antoLeader', 'capitanoccc', 'NA', 'san paolo', 'feudo', 3256787766, 'IT09T4567665433789099887767', 'pallavolo'),
('root', 'root', 'NA', 'san paolo', 'feudo', 123456787, 'asdasd', 'basket'),
('barbarella', 'barbie00', 'SA', 'baronissi', 'vittorio emanuele', 3099998883, 'IT02G789658888882340098772', 'paddle');

insert into gestore values
('gennaro99','gennaro','scognamiglio', 'zucchineggg', 'SA', 'baronissi', 'vittorio veneto', 'IT96Q2266789876543668890022', 3289095543),
('carlo97','carlo','tammarro', 'sonosolare', 'SA', 'mercato san severino', 'curcumvallazione', 'IT97T0066789876543668890022',3667895543),
('giulio99','giulio','incoronato', 'studiostudio', 'NA', 'piazzolla', 'antonio ciccone', 'IT99G6699009988776543780976', 3289876654),
('antonio66','antonio','scognamiglio', 'ooiiuuyytt', 'AV', 'aversa', 'antonio ciccone', 'IT96Q2266789876543668890022', 3289095543),
('marioM', 'mario', 'marrone', 'uiuiuiui', 'NA', 'poimigliano d arco', 'via delle carote', 'IT96Q1111112255543668890022', 3278906654),
('ernestoT', 'ernesto', 'tafuro', 'uiooooui', 'SA', 'nocera inferiore', 'via giuseppe mazzini', 'IT96Q1199885655543042890022', 3098201654),
('ernesto00', 'ernesto', 'castaldo', 'ooooui', 'SA', 'baronissi', 'via degli ulivi' ,'IT96Q1199885655830570943722', 3087689054);

insert into sport values
('calcio'),
('tennis'),
('pallavolo'),
('basket'),
('calcetto'),
('paddle');

insert into evento values
('partitina', 'calcio', 'pollicino', '2023-02-19', 18.00),
('partita.tennis', 'tennis', 'palla d oro', '2023-03-18', 15.00),
('giochiamoInsieme', 'pallavolo', 'bombonera', '2023-03-20', 15.00),
('amanti del basket', 'basket', 'campetti nike','2023-04-21',17.30),
('calciando', 'calcetto', 'real football', '023-03-22', 18.55),
('paddleLove', 'paddle', 'blue paddle club','2023-04-01',15.00),
('pallavolo-partita', 'pallavolo', 'sporting club','2023-03-24',20.00);

insert into campo values
('pollicino', 22, 'NA', 'saviao', 'v.gemito', 100.00, 100.00, 65.50 ),
('palla d\oro',2 , 'SA', 'Baronissi', 'delle castagne', 15.00, 23.00, 10.15),
('bombonera', 12, 'AV', 'avella', 'degli ulivi',60.00 ,18.00 ,9.00 ),
('campetti nike',10 , 'SA', 'nocera inferore', 'via dei pomodori', 50.00, 28.00, 15.00),
('real football', 10, 'SA', 'mercato sanseverino', 'via della fontana',50.00 ,35.00 , 20.00 ),
('blue paddle club', 4, 'SA', 'baronissi', 'via genovesi', 40.00, 20.00, 10.00),
('sporting club', 12, 'NA', 'saviano', 'antonio ciccone', 70.00 ,20.00 , 11.00 );

insert into prenotazione values
(1, 'annachiara01', 'partitina'),
(2, 'genn09', 'partita.tennis'),
(3, 'armandino88', 'giochiamoInsieme'),
(4, 'mariolino', 'amanti del basket'),
(5, 'carlino01', 'calciando'),
(6, 'antoLeader', 'pallavolo-partita'),
(7,'cucciolone70', 'paddleLove' );

insert into gestisce values
('gennaro99','campetti nike'),
('carlo97', 'real football'),
('giulio99', 'pollicino'),
('antonio66', 'bombonera'),
('marioM', 'sporting club'),
('ernesto00','blue paddle club'),
('ernestoT','palla d\oro');




