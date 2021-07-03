-- public.author definition

-- Drop table

-- DROP TABLE public.author;

CREATE TABLE public.author (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	"name" varchar(255) NULL,
	CONSTRAINT author_pkey PRIMARY KEY (id)
);


-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT category_pkey PRIMARY KEY (id)
);


-- public.file definition

-- Drop table

-- DROP TABLE public.file;

CREATE TABLE public.file (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	file_name varchar(255) NULL,
	original_file_name varchar(255) NULL,
	url varchar(255) NULL,
	CONSTRAINT file_pkey PRIMARY KEY (id)
);


-- public."language" definition

-- Drop table

-- DROP TABLE public."language";

CREATE TABLE public."language" (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT language_pkey PRIMARY KEY (id)
);


-- public."library" definition

-- Drop table

-- DROP TABLE public."library";

CREATE TABLE public."library" (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	address varchar(255) NOT NULL,
	cep varchar(255) NOT NULL,
	city varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	neighborhood varchar(255) NOT NULL,
	"number" varchar(255) NOT NULL,
	CONSTRAINT library_pkey PRIMARY KEY (id)
);


-- public."role" definition

-- Drop table

-- DROP TABLE public."role";

CREATE TABLE public."role" (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	"name" varchar(255) NULL,
	CONSTRAINT role_pkey PRIMARY KEY (id)
);


-- public.book definition

-- Drop table

-- DROP TABLE public.book;

CREATE TABLE public.book (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	edition varchar(255) NOT NULL,
	isbn varchar(255) NOT NULL,
	publishing_company varchar(255) NOT NULL,
	synopsis text NOT NULL,
	title varchar(255) NOT NULL,
	total_pages int4 NOT NULL,
	year_of_publication varchar(255) NOT NULL,
	category_id uuid NULL,
	file_id uuid NULL,
	language_id uuid NULL,
	CONSTRAINT book_pkey PRIMARY KEY (id),
	CONSTRAINT fkam9riv8y6rjwkua1gapdfew4j FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fkkfi5agqw1cx6461wgixqgkj3o FOREIGN KEY (file_id) REFERENCES file(id),
	CONSTRAINT fkmrhfp9wfi5dy4bwl87bx8ivua FOREIGN KEY (language_id) REFERENCES language(id)
);


-- public.book_authors definition

-- Drop table

-- DROP TABLE public.book_authors;

CREATE TABLE public.book_authors (
	book_id uuid NOT NULL,
	authors_id uuid NOT NULL,
	CONSTRAINT fk551i3sllw1wj7ex6nir16blsm FOREIGN KEY (authors_id) REFERENCES author(id),
	CONSTRAINT fks4xm7q8i3uxvaiswj1c35nnxw FOREIGN KEY (book_id) REFERENCES book(id)
);


-- public.book_libraries definition

-- Drop table

-- DROP TABLE public.book_libraries;

CREATE TABLE public.book_libraries (
	book_id uuid NOT NULL,
	library_id uuid NOT NULL,
	CONSTRAINT fkfe5g4i4473w8y2acpjw0ldjfw FOREIGN KEY (library_id) REFERENCES library(id),
	CONSTRAINT fkrcrwntswrl00sanmmo12d86si FOREIGN KEY (book_id) REFERENCES book(id)
);


-- public."event" definition

-- Drop table

-- DROP TABLE public."event";

CREATE TABLE public."event" (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	"date" date NOT NULL,
	"hour" varchar(255) NOT NULL,
	status int4 NULL,
	title varchar(255) NOT NULL,
	library_id uuid NULL,
	CONSTRAINT event_pkey PRIMARY KEY (id),
	CONSTRAINT fkhj638qa2oeks4wxe9wiu6uks5 FOREIGN KEY (library_id) REFERENCES library(id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	email varchar(255) NOT NULL,
	"name" varchar(80) NOT NULL,
	"password" varchar(255) NOT NULL,
	role_id uuid NULL,
	CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT fk4qu1gr772nnf6ve5af002rwya FOREIGN KEY (role_id) REFERENCES role(id)
);


-- public.customer definition

-- Drop table

-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	cpf varchar(255) NOT NULL,
	phone varchar(11) NULL,
	id uuid NOT NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (id),
	CONSTRAINT fkhu8qiqgy7buhjc5s739s4x8we FOREIGN KEY (id) REFERENCES users(id)
);


-- public.loan definition

-- Drop table

-- DROP TABLE public.loan;

CREATE TABLE public.loan (
	id uuid NOT NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	date_end date NULL,
	date_start date NULL,
	scheduled_date date NULL,
	status int4 NULL,
	book_id uuid NULL,
	customer_id uuid NULL,
	library_id uuid NULL,
	CONSTRAINT loan_pkey PRIMARY KEY (id),
	CONSTRAINT fk88c0ydlo57pcgp137tntrgqx1 FOREIGN KEY (book_id) REFERENCES book(id),
	CONSTRAINT fkcwv05agfqwg5ndy6adbefsx7d FOREIGN KEY (customer_id) REFERENCES customer(id),
	CONSTRAINT fkgjticxpyvhf1w48gm96t0uev3 FOREIGN KEY (library_id) REFERENCES library(id)
);