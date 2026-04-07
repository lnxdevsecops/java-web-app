<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GANGA Training & Consulting</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:ital,wght@0,400;0,500;0,600;0,700;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <a class="skip-link" href="#main">Skip to content</a>

    <header class="header" id="top">
        <nav class="site-nav" aria-label="Primary">
            <div class="container nav-inner">
                <a class="brand" href="#top">GANGA</a>
                <ul class="nav-links">
                    <li><a href="#about">About</a></li>
                    <li><a href="#services">Services</a></li>
                    <li><a href="#courses">Courses</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div>
        </nav>
        <div class="hero">
            <div class="container hero-content">
                <p class="hero-eyebrow">Training &amp; Consulting</p>
                <h1>GANGA Training &amp; Consulting</h1>
                <p class="hero-tagline">Empowering professionals for a brighter future</p>
                <a href="#services" class="btn btn-primary">Explore services</a>
            </div>
        </div>
    </header>

    <main id="main">
        <section id="about" class="section about">
            <div class="container narrow">
                <h2 class="section-title">About us</h2>
                <p class="lead">At GANGA Training &amp; Consulting, we provide top-notch training and consulting services to help professionals thrive in their careers.</p>
            </div>
        </section>

        <section id="services" class="section services">
            <div class="container">
                <h2 class="section-title">Our services</h2>
                <div class="services-grid">
                    <article class="service-card">
                        <h3>Professional training</h3>
                        <p>Upgrade your skills with our expert-led training programs.</p>
                    </article>
                    <article class="service-card">
                        <h3>Consulting services</h3>
                        <p>Transform your business with our tailored consulting solutions.</p>
                    </article>
                </div>
            </div>
        </section>

        <section id="courses" class="section courses">
            <div class="container">
                <h2 class="section-title">Upcoming courses</h2>
                <ul class="course-list">
                    <li class="course-card">
                        <span class="course-label">Course</span>
                        <span class="course-title">DevOps/SRE</span>
                        <span class="course-meta">Coming soon</span>
                    </li>
                    <li class="course-card">
                        <span class="course-label">Course</span>
                        <span class="course-title">Advanced Kubernetes Administrator (CKA/CKAD)</span>
                        <span class="course-meta">Coming soon</span>
                    </li>
                    <li class="course-card">
                        <span class="course-label">Course</span>
                        <span class="course-title">Certified Kubernetes Security Specialist (CKS)</span>
                        <span class="course-meta">Coming soon</span>
                    </li>
                </ul>
            </div>
        </section>

        <section id="contact" class="section contact">
            <div class="container narrow">
                <h2 class="section-title">Contact us</h2>
                <form class="contact-form" method="post" action="#">
                    <div class="field">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" placeholder="Your name" required autocomplete="name">
                    </div>
                    <div class="field">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" placeholder="you@example.com" required autocomplete="email">
                    </div>
                    <div class="field">
                        <label for="message">Message</label>
                        <textarea id="message" name="message" rows="5" placeholder="How can we help?" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Send message</button>
                </form>
            </div>
        </section>
    </main>

    <footer class="footer">
        <div class="container">
            <p>&copy; 2026 GANGA Training &amp; Consulting. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
