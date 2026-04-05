@import de.paladinsinn.pandurart.web.MarkdownContent
@import de.paladinsinn.pandurart.web.MarkdownService
@import de.paladinsinn.pandurart.web.Page
@param Page page
@param MarkdownService md
@param String contextPath = ""

@template.layout(
    title = "Terms of Service",
    page = page,
    contextPath = contextPath,
    content = MarkdownContent.of(md, """
# Nutzungsbedingungen

Willkommen beiRollenspiel-Cons!

_**TBD**_
""")
)

