<html>
<body>
<h1>Recipe Scraper</h1>
<section>
    <h2>Get By Categories Documentation</h2>
    <p> - Retrieval time ~ 10-40 minutes (depending on how many pages are chosen for scraping)</p>
    <p> - Usage: Database Storage</p>
    <p>
        <b>NOTE:</b> Although this method of data retrieval takes several minutes to process, the main application for it is to easily
        create JSON output that can be saved to a .json file that is then used to create database tables filled with rows of
        data.  The following two use cases are detailed below and example JSON is provided.
    </p>
</section>
<br>
<section>
    <h3> Responses: 2 types </h3>
    <p>
        <b>1.</b>  .../services/categories/ <br>
        ALL Categories and corresponding recipes
        <br>
        <br>
        <b>2.</b>  .../services/categories/{category-name-parameter} <br>
        ONE category and corresponding recipes
    </p>
</section>

<br>

<p style="font-size: 18px;">
    <b>*Below is a step-by-step tutorial that uses a response to map/populate a database in MySql Workbench*</b>
</p>

<br />

<h3>Example JSON output</h3>

<img src="category-by-all.png" alt="category-by-all" width="500" height="600">

<br>
<hr>

<h3>Instructions to import JSON response into MySql Workbench</h3>

<h4>Step 1 : Save Response to .json file</h4>

<img src="database-import-step-by-step/step1.png" alt="step1" width="500" height="600">

<h4>Step 2 : Create New Schema</h4>

<img src="database-import-step-by-step/step2.png" alt="step2" width="500" height="600">

<h4>Step 3 : Browse and find the .json file</h4>

<img src="database-import-step-by-step/step3.png" alt="step3" width="500" height="600">

<h4>Step 3 : Browse and find the .json file</h4>
<p>HINT: Right click on schema and choose 'Table Data Import Wizard'</p>

<img src="database-import-step-by-step/step3.png" alt="step3" width="500" height="600">

<h4>Step 4 : Name the table</h4>

<img src="database-import-step-by-step/step4.png" alt="step4" width="500" height="600">

<h4>Step 5 : Select desired Columns to map</h4>

<img src="database-import-step-by-step/step5.png" alt="step5" width="500" height="600">

<h4>Step 6 : Finish Import and examine the new table</h4>

<img src="database-import-step-by-step/step6_1.png" alt="step6_1" width="500" height="600">
<br />
<img src="database-import-step-by-step/step6_2.png" alt="step6_2" width="500" height="600">
<br />
<img src="database-import-step-by-step/step6_3.png" alt="step6_3" width="500" height="600">
<br />

</body>
</html>
