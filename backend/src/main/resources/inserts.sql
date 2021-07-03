INSERT INTO "role" ("id", "name", created_at, updated_at) VALUES ('b626220fab654167949d72cae8f72c45', 'ROLE_ADMIN', current_timestamp, current_timestamp);
-- b626220f-ab65-4167-949d-72cae8f72c45
INSERT INTO "role" ("id", "name", created_at, updated_at) VALUES ('7e7f1b883f0b4503b5c4bead1623dcaf', 'ROLE_USER', current_timestamp, current_timestamp);
-- 7e7f1b88-3f0b-4503-b5c4-bead1623dcaf

INSERT INTO "users" (id, "name", email, "password", role_id, created_at, updated_at) VALUES ('631caa7634b84634b1fb3aa42447bba4', 'Jose Santos', 'jose@email.com', '$2a$10$HdaWs4kh1IDjxXP989mmV.B6N4L70H6YH474gid15SrTtMzHvhVkO', '7e7f1b883f0b4503b5c4bead1623dcaf', current_timestamp, current_timestamp);
-- 631caa76-34b8-4634-b1fb-3aa42447bba4
INSERT INTO customer (id, cpf, phone) VALUES ('631caa7634b84634b1fb3aa42447bba4', '12345678910', '4422223333');

INSERT INTO "users" (id, "name", email, "password", role_id, created_at, updated_at) VALUES ('7912780d35c64006bac6619e1678a19a', 'Admin 1', 'admin1@email.com', '$2a$10$HdaWs4kh1IDjxXP989mmV.B6N4L70H6YH474gid15SrTtMzHvhVkO', 'b626220fab654167949d72cae8f72c45', current_timestamp, current_timestamp);
-- 7912780d-35c6-4006-bac6-619e1678a19a

INSERT INTO "library" (id, cep, "address", city, "number", "name", neighborhood, created_at, updated_at) VALUES ('0e7dc02bea334fc2ad10608faba03527', '88150-300', 'Av. Horácio Racanello', 'Maringá', '6090', 'Bento Munhoz da Rocha Neto (Centro)', 'Novo Centro', current_timestamp, current_timestamp);
-- 0e7dc02b-ea33-4fc2-ad10-608faba03527
INSERT INTO "library" (id, cep, "address", city, "number", "name", neighborhood, created_at, updated_at) VALUES ('c5c0cff7c66e4a3fa072fa23774308a1', '81385-480', 'Av. Vereador Antonio Bortolotto', 'Maringá', '', 'Centro de Artes e Esportes Unificados - Iguatemi', 'Iguatemi', current_timestamp, current_timestamp);
-- c5c0cff7-c66e-4a3f-a072-fa23774308a1
INSERT INTO "library" (id, cep, "address", city, "number", "name", neighborhood, created_at, updated_at) VALUES ('e00c1e4866fa44d189139db3e5e66d59', '81385-480', 'Tv. Liberdade', 'Maringá', '26', 'Pioneiro Manoel Pereira Camacho Filho (Operária)', 'Vila Operária', current_timestamp, current_timestamp);
-- e00c1e48-66fa-44d1-8913-9db3e5e66d59
INSERT INTO "library" (id, cep, "address", city, "number", "name", neighborhood, created_at, updated_at) VALUES ('f712d0c5826347dab698ea8b90c93183', '81385-480', 'Av. Dona Sophia Rasgulaeff', 'Maringá', '693', 'Pioneiro Nilo Gravena (Jd. Alvorada)', 'Jd. Alvorada', current_timestamp, current_timestamp);
-- f712d0c5-8263-47da-b698-ea8b90c93183
INSERT INTO "library" (id, cep, "address", city, "number", "name", neighborhood, created_at, updated_at) VALUES ('52bfb3a654554f37996122920f08c3c3', '81385-480', 'Av. São Judas Tadeu', 'Maringá', '1429', 'Professora Maria Aparecida da Cunha Soares (Palmeiras)', 'Parque das Palmeiras', current_timestamp, current_timestamp);
-- 52bfb3a6-5455-4f37-9961-22920f08c3c3
INSERT INTO "library" (id, cep, "address", city, "number", "name", neighborhood, created_at, updated_at) VALUES ('e73338f6d1714d5c9f2bf1d14ad5020e', '81385-480', 'Av. Mandacaru', 'Maringá', '317', 'Professora Tomires Moreira de Carvalho (Mandacaru)', 'Jardim Maravilha', current_timestamp, current_timestamp);
-- e73338f6-d171-4d5c-9f2b-f1d14ad5020e

INSERT INTO "event" (id, title, library_id, "hour", "date", "status", created_at, updated_at) VALUES ('9f7d030cf3ba469b8771acc7ce8fbfe1', 'Clube da Leitura', 'c5c0cff7c66e4a3fa072fa23774308a1', '15:30 as 16:30', current_timestamp, 0, current_timestamp, current_timestamp);
-- 9f7d030c-f3ba-469b-8771-acc7ce8fbfe1
INSERT INTO "event" (id, title, library_id, "hour", "date", "status", created_at, updated_at) VALUES ('74d3f673f86148cc9abffbed9ecb5e5a', 'Hora da Leitura', 'e73338f6d1714d5c9f2bf1d14ad5020e', '16:00 as 17:30', current_timestamp, 0, current_timestamp, current_timestamp);
-- 74d3f673-f861-48cc-9abf-fbed9ecb5e5a


INSERT INTO "author" (id, "name", created_at, updated_at) VALUES ('0dad8c94af374a9d9cc1421c030ba6b8', 'Ian Sommerville', current_timestamp, current_timestamp);
-- 0dad8c94-af37-4a9d-9cc1-421c030ba6b8
INSERT INTO "author" (id, "name", created_at, updated_at) VALUES ('1b7583818ef14c80905135393c063bdb', 'Robert C. Martin', current_timestamp, current_timestamp);
-- 1b758381-8ef1-4c80-9051-35393c063bdb
INSERT INTO "author" (id, "name", created_at, updated_at) VALUES ('d26cc14c6c4d4fd1be1a810297b0418e', 'Paul Deitel', current_timestamp, current_timestamp);
-- d26cc14c-6c4d-4fd1-be1a-810297b0418e
INSERT INTO "author" (id, "name", created_at, updated_at) VALUES ('c9014e6c4ca14b1897d4fd27252f1772', 'Harvey Deitel', current_timestamp, current_timestamp);
-- c9014e6c-4ca1-4b18-97d4-fd27252f1772
INSERT INTO "author" (id, "name", created_at, updated_at) VALUES ('9ac75a94bee3467cb4a54ba3aef8da16', 'Andrew Stellman', current_timestamp, current_timestamp);
-- 9ac75a94-bee3-467c-b4a5-4ba3aef8da16
INSERT INTO "author" (id, "name", created_at, updated_at) VALUES ('86e16dcc168442bd84c1be1001bf18fe', 'Loiane Groner', current_timestamp, current_timestamp);
-- 86e16dcc-1684-42bd-84c1-be1001bf18fe
INSERT INTO "author" (id, "name", created_at, updated_at) VALUES ('0741439ced26450d931a4448f5d2d9dc', 'Steve Krug', current_timestamp, current_timestamp);
-- 0741439c-ed26-450d-931a-4448f5d2d9dc

INSERT INTO "category" (id, "name", created_at, updated_at) VALUES ('4e0a58c099414f8c980a8932d9a0704f', 'Tecnologia', current_timestamp, current_timestamp);
-- 4e0a58c0-9941-4f8c-980a-8932d9a0704f
INSERT INTO "category" (id, "name", created_at, updated_at) VALUES ('a9c9998d26054f93b2ae27fb36cc0b62', 'Poesia', current_timestamp, current_timestamp);
-- a9c9998d-2605-4f93-b2ae-27fb36cc0b62
INSERT INTO "category" (id, "name", created_at, updated_at) VALUES ('83c9c470657d44f8baf8527311ae96ff', 'Ficção', current_timestamp, current_timestamp);
-- 83c9c470-657d-44f8-baf8-527311ae96ff

INSERT INTO "language" (id, "name", created_at, updated_at) VALUES ('6722d4c4f4f9432c8b729a534021a596', 'Português', current_timestamp, current_timestamp);
-- 6722d4c4-f4f9-432c-8b72-9a534021a596
INSERT INTO "language" (id, "name", created_at, updated_at) VALUES ('38c0a0a28a3645f38ec253d9cd0a0e9d', 'Inglês', current_timestamp, current_timestamp);
-- 38c0a0a2-8a36-45f3-8ec2-53d9cd0a0e9d

INSERT INTO "file" (id, file_name, original_file_name, url, created_at, updated_at) VALUES ('74378ae8baa642f59d6261ee22ed6c79', 'clean-code.jpg', 'clean-code.jpg', 'http://localhost:8080', current_timestamp, current_timestamp);
-- 74378ae8-baa6-42f5-9d62-61ee22ed6c79
INSERT INTO "file" (id, file_name, original_file_name, url, created_at, updated_at) VALUES ('b744596c4bca43a8bf2c0320fcfcc7df', 'engenharia-de-software.jpg', 'engenharia-de-software.jpg', 'http://localhost:8080', current_timestamp, current_timestamp);
-- b744596c-4bca-43a8-bf2c-0320fcfcc7df
INSERT INTO "file" (id, file_name, original_file_name, url, created_at, updated_at) VALUES ('1263462eb590437a9e6216b95a970f32', 'estrutura-de-dados-js.jpg', 'estrutura-de-dados-js.jpg', 'http://localhost:8080', current_timestamp, current_timestamp);
-- 1263462e-b590-437a-9e62-16b95a970f32
INSERT INTO "file" (id, file_name, original_file_name, url, created_at, updated_at) VALUES ('0d3597ab092a42e4b3d77450bfdf4ce3', 'java-como-programar.jpg', 'java-como-programar.jpg', 'http://localhost:8080', current_timestamp, current_timestamp);
-- 0d3597ab-092a-42e4-b3d7-7450bfdf4ce3
INSERT INTO "file" (id, file_name, original_file_name, url, created_at, updated_at) VALUES ('eba6dd63370542199a337182884fed21', 'nao-me-faca-pensar.jpg', 'nao-me-faca-pensar.jpg', 'http://localhost:8080', current_timestamp, current_timestamp);
-- eba6dd63-3705-4219-9a33-7182884fed21
INSERT INTO "file" (id, file_name, original_file_name, url, created_at, updated_at) VALUES ('29264865ef844e59856c22b39d4ccafd', 'use-a-cabeca-csharp.jpg', 'use-a-cabeca-csharp.jpg', 'http://localhost:8080', current_timestamp, current_timestamp);
-- 29264865-ef84-4e59-856c-22b39d4ccafd

INSERT INTO "book" (id, "edition", publishing_company, isbn, synopsis, title, total_pages, year_of_publication, category_id, language_id, file_id, created_at, updated_at)  VALUES ('dcbf4f69c074447987847b7f313a51d5', 1, 'Prentice Hall PTR', '9780132350884',  'Editora: Mesmo um código ruim pode funcionar. Mas se ele não for limpo, pode acabar com uma empresa de desenvolvimento. Perdem-se a cada ano horas incontáveis e recursos importantes devido a um código mal escrito. Mas não precisa ser assim. O renomado especialista em software, Robert C. Martin, apresenta um paradigma revolucionário com Código limpo: Habilidades Práticas do Agile Software.', 'Clean Code', 431, 2008, '4e0a58c099414f8c980a8932d9a0704f', '6722d4c4f4f9432c8b729a534021a596', '74378ae8baa642f59d6261ee22ed6c79', current_timestamp, current_timestamp);
-- dcbf4f69-c074-4479-8784-7b7f313a51d5
INSERT INTO "book_authors" (book_id, authors_id) VALUES ('dcbf4f69c074447987847b7f313a51d5', '1b7583818ef14c80905135393c063bdb');

INSERT INTO "book" (id, "edition", publishing_company, isbn, synopsis, title, total_pages, year_of_publication, category_id, language_id, file_id, created_at, updated_at) VALUES ('bbbc7da253d74bd5aa6af2bca3707bef', 8, 'Pearson', '-',  'O livro se destina, em primeiro lugar, a estudantes de faculdades e universidades que estejam frequentando au-las introdutórias ou avançadas de engenharia de sistemas e de software. ', 'Engenharia de Sofware', 568, 2007, '4e0a58c099414f8c980a8932d9a0704f', '6722d4c4f4f9432c8b729a534021a596', 'b744596c4bca43a8bf2c0320fcfcc7df', current_timestamp, current_timestamp);
-- bbbc7da2-53d7-4bd5-aa6a-f2bca3707bef
INSERT INTO "book_authors" (book_id, authors_id) VALUES ('bbbc7da253d74bd5aa6af2bca3707bef', '0dad8c94af374a9d9cc1421c030ba6b8');

INSERT INTO "book" (id, "edition", publishing_company, isbn, synopsis, title, total_pages, year_of_publication, category_id, language_id, file_id, created_at, updated_at) VALUES ('019330bb44be4bd89a2c32d0eaef2d91', 2, 'Novatec Editora', '9788575226933',  'Uma estrutura de dados é uma maneira particular de organizar dados em um computador com o intuito de usar os recursos de modo eficaz. As estruturas de dados e os algoritmos são a base de todas as soluções para qualquer problema de programação', 'Estruturas de dados e algoritmos com javascript', 408, 2019, '4e0a58c099414f8c980a8932d9a0704f', '6722d4c4f4f9432c8b729a534021a596', '1263462eb590437a9e6216b95a970f32', current_timestamp, current_timestamp);
-- dcbf4f69-c074-4479-8784-7b7f313a51d5
INSERT INTO "book_authors" (book_id, authors_id) VALUES ('019330bb44be4bd89a2c32d0eaef2d91', '86e16dcc168442bd84c1be1001bf18fe');

INSERT INTO "book" (id, "edition", publishing_company, isbn, synopsis, title, total_pages, year_of_publication, category_id, language_id, file_id, created_at, updated_at) VALUES ('8b88130265f44d1885f86405afb0e6d9', 10, 'Pearson', '8543004799',  'Milhões de alunos e profissionais aprenderam programação e desenvolvimento de software com os livros Deitel®. Java: como programar, 10ª edição, fornece uma introdução clara, simples, envolvente e divertida à programação Java com ênfase inicial em objetos.', 'Java Como Programar', 968, 2016, '4e0a58c099414f8c980a8932d9a0704f', '6722d4c4f4f9432c8b729a534021a596', '0d3597ab092a42e4b3d77450bfdf4ce3', current_timestamp, current_timestamp);
-- 8b881302-65f4-4d18-85f8-6405afb0e6d9
INSERT INTO "book_authors" (book_id, authors_id) VALUES ('8b88130265f44d1885f86405afb0e6d9', 'd26cc14c6c4d4fd1be1a810297b0418e');
INSERT INTO "book_authors" (book_id, authors_id) VALUES ('8b88130265f44d1885f86405afb0e6d9', 'c9014e6c4ca14b1897d4fd27252f1772');

INSERT INTO "book" (id, "edition", publishing_company, isbn, synopsis, title, total_pages, year_of_publication, category_id, language_id, file_id, created_at, updated_at) VALUES ('98bcfaf5ae6549cab28e17d8015339bf', 2, 'Alta Books', '8576085593',  'O Use a Cabeça! C# – 2ª Edição é uma experiência completa de aprendizagem para a programação com C#, .NET Framework e IDE Visual Studio. Construído para ser assimilado rapidamente pela sua mente, este livro cobre o C# & .NET 4.0 e o Visual Studio 2010, e ensina tudo, desde a herança até a serialização.', 'Use a Cabeça! C#', 738, 2013, '4e0a58c099414f8c980a8932d9a0704f', '6722d4c4f4f9432c8b729a534021a596', '29264865ef844e59856c22b39d4ccafd', current_timestamp, current_timestamp);
-- 98bcfaf5-ae65-49ca-b28e-17d8015339bf
INSERT INTO "book_authors" (book_id, authors_id) VALUES ('98bcfaf5ae6549cab28e17d8015339bf', '9ac75a94bee3467cb4a54ba3aef8da16');

INSERT INTO "book" (id, "edition", publishing_company, isbn, synopsis, title, total_pages, year_of_publication, category_id, language_id, file_id, created_at, updated_at) VALUES ('f5ca03e14f81407ca18f10cc0cede214', 1, 'Alta Books', '8576088509',  'Dê um basta aos problemas de usabilidade! Clássico do autor Steve Krug ganha nova edição pela Alta Books.Quantas vezes você se sentiu perdido em um site? Quantas outras falhou ao tentar entender como funcionava um aplicativo? Na maioria das vezes, a culpa não é sua.', 'Não Me Faça Pensar', 212, 2014, '4e0a58c099414f8c980a8932d9a0704f', '6722d4c4f4f9432c8b729a534021a596', 'eba6dd63370542199a337182884fed21', current_timestamp, current_timestamp);
-- f5ca03e14f81407ca18f10cc0cede214
INSERT INTO "book_authors" (book_id, authors_id) VALUES ('f5ca03e14f81407ca18f10cc0cede214', '0741439ced26450d931a4448f5d2d9dc');

INSERT INTO book_libraries (book_id, library_id) VALUES ('f5ca03e14f81407ca18f10cc0cede214', '0e7dc02bea334fc2ad10608faba03527');
INSERT INTO book_libraries (book_id, library_id) VALUES ('f5ca03e14f81407ca18f10cc0cede214', 'c5c0cff7c66e4a3fa072fa23774308a1');

INSERT INTO book_libraries (book_id, library_id) VALUES ('98bcfaf5ae6549cab28e17d8015339bf', 'c5c0cff7c66e4a3fa072fa23774308a1');
INSERT INTO book_libraries (book_id, library_id) VALUES ('8b88130265f44d1885f86405afb0e6d9', 'c5c0cff7c66e4a3fa072fa23774308a1');

INSERT INTO book_libraries (book_id, library_id) VALUES ('019330bb44be4bd89a2c32d0eaef2d91', 'e00c1e4866fa44d189139db3e5e66d59');
INSERT INTO book_libraries (book_id, library_id) VALUES ('bbbc7da253d74bd5aa6af2bca3707bef', 'e73338f6d1714d5c9f2bf1d14ad5020e');

INSERT INTO book_libraries (book_id, library_id) VALUES ('dcbf4f69c074447987847b7f313a51d5', 'f712d0c5826347dab698ea8b90c93183');
INSERT INTO book_libraries (book_id, library_id) VALUES ('019330bb44be4bd89a2c32d0eaef2d91', '52bfb3a654554f37996122920f08c3c3');

INSERT INTO loan (id, customer_id, date_end, date_start, scheduled_date, status, book_id, library_id, created_at, updated_at) VALUES ('549777dfc8ca421b99e2f4c634edee7b', '631caa7634b84634b1fb3aa42447bba4', current_timestamp, current_timestamp, current_timestamp, 0, 'dcbf4f69c074447987847b7f313a51d5', 'f712d0c5826347dab698ea8b90c93183', current_timestamp, current_timestamp);
-- 549777df-c8ca-421b-99e2-f4c634edee7b
INSERT INTO loan (id, customer_id, date_end, date_start, scheduled_date, status, book_id, library_id, created_at, updated_at) VALUES ('28277c90969b41f5ab2d6c6fc4595c0c', '631caa7634b84634b1fb3aa42447bba4', null, null, current_timestamp, 0, '019330bb44be4bd89a2c32d0eaef2d91', 'e00c1e4866fa44d189139db3e5e66d59', current_timestamp, current_timestamp);
-- 28277c90-969b-41f5-ab2d-6c6fc4595c0c
INSERT INTO loan (id, customer_id, date_end, date_start, scheduled_date, status, book_id, library_id, created_at, updated_at) VALUES ('7b3a93c377ac46959d6edca0e34fd97b', '631caa7634b84634b1fb3aa42447bba4', current_timestamp, current_timestamp, current_timestamp, 1, 'bbbc7da253d74bd5aa6af2bca3707bef', 'e73338f6d1714d5c9f2bf1d14ad5020e', current_timestamp, current_timestamp);
-- 7b3a93c3-77ac-4695-9d6e-dca0e34fd97b