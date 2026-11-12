# IFC performance implementation plan

> For agentic workers: implement the independent backend and renderer tasks in parallel; the coordinator integrates UI loading, compression, verification and test deployment. No intermediate approval is needed for this authorized scope.

**Goal:** Complete the four measured IFC performance improvements and publish the verified result to the existing test environment.

**Architecture:** Preserve business calculations and permissions. Replace per-artifact aggregate subqueries, revalidate authenticated model resources with private ETags, reuse bounded session model data and decoded geometry, virtualize the component tree and update selection incrementally. Compress HTTP transfers without changing model bytes.

**Tech stack:** Existing Java/Spring/MySQL 8, Vue/Element Plus/Three.js, Python publishing tools and Nginx. No new dependencies or schema changes.

**Spec:** The user's confirmed four-item optimization request and the measured baseline in `/tmp/ljaps-ifc-perf-etPUTXJf/audit.json`. The existing IFC behavior is described in `20-rebuild/integrations/ifc/README.md`.

## Constraints and review focus

- Keep quantity/weight results identical, including multiple records per mark, nulls, deleted rows and irrelevant task types.
- Authorize project, monomer, area and current revision before serving either model bytes or HTTP 304. Vary private caches by Authorization and Accept-Encoding; never make model files public.
- Revalidate access before in-memory reuse. Clear account-specific cache state when the token changes, bound retained bundles and cancel superseded loads safely.
- Keep the whole-model 100% zoom basis, element/assembly selection distinctions, status colors, hidden parts, tree expansion and scroll retention.
- Preserve the earlier Docker subnet repair, backend heap safeguards and native BIMFACE model mapping. Do not restore or replace the database.
- The separately observed unavailable drawing file must be diagnosed; do not claim its full preview has passed unless the actual file renders.

## Tasks

### 1. Backend progress and private conditional responses

Files: `20-rebuild/backend/app/src/main/java/com/ljaps/rebuild/business/IfcModelController.java` and focused probes.

- [x] Pin aggregate-result equivalence and authorization-before-304 with meaningful regressions.
- [x] Use one aggregate per relevant source table, restricted to target artifacts, and keep the endpoint result fields unchanged.
- [x] Add revision/file ETags and `private, no-cache, must-revalidate` responses after existing authorization. Do not cache progress or component data.
- [x] Verify both measured areas against the original SQL and synthetic read-only fixtures; compile the application.

### 2. Renderer hot paths and decoded-model reuse

Files: IFC `viewer.js`, focused renderer helper if necessary, and isolated tests.

- [x] Test the unchanged selection/visibility/focus semantics and that selection-only changes do not rewrite all instance matrices.
- [x] Index elements, marks and assemblies; cache bounds; skip empty draw batches and update only changed selections.
- [x] Reuse decoded geometry for the same ArrayBuffer while keeping per-view state independent and releasing GPU resources on disposal. Coordinate with the bounded bundle cache.
- [x] Preserve the public viewer interface and verify mode switches, zoom and repeated model disposal.

### 3. Workspace loading, cache and tree

Files: IFC `index.vue.js`, `viewer.css`, a focused `model-cache.js`, existing navigation utilities and frontend checks.

- [x] Add bounded, token-scoped completed-bundle reuse with authenticated index revalidation on each open and conditional browser caching for full reloads.
- [x] Let the model become interactive independently of the progress response. Represent pending/error progress explicitly.
- [x] Avoid redundant detail requests when the selected business mark is unchanged.
- [x] Replace full root-node DOM construction with the existing virtual tree component, debounce filtering, and retain expansion/scroll while the detail panel is open.
- [x] Exercise first/repeat loading, cancellation, token change, revoked access, model version changes, tree search, checkbox state and detail reopening.

### 4. Compression and release

Files: reusable deployment/gateway configuration, IFC documentation and private release artifacts.

- [x] Enable tested gzip types for JavaScript, JSON, CSS and GLB while preserving authentication and correct Vary headers.
- [x] Build frontend/backend, run appropriate suites and inspect the real page.
- [x] Create a new rollback-capable release from the current server configuration, keeping database, attachments and native BIMFACE scope/cache intact.
- [x] Re-run the baseline workflows, including 10Mbps/80ms network emulation and Retina rendering; record measured before/after values.
- [x] Confirm source/build/server parity, health and actual native BIMFACE regression checks before reporting completion.


## Verification outcome

Implemented and verified on 2026-11-12. Frontend suite, IFC cache/renderer/navigation checks, application build, private conditional HTTP probes and publication checks pass. Both measured server areas match the old aggregate exactly (814 and79 result rows), without schema/data changes. Actual browser checks cover warm revalidation, rejected cache access, failed progress with an operable model, tree state retention, modes, focus and Retina rotation.

Server test release: `20261112-160443-ifc-perf`, preserving current network/heap/ACL/BIMFACE configuration. Active local3120 has the same frontend and the scoped IFC controller update. Evidence/report: `20-rebuild/integrations/ifc/performance-20261112.md`. Source is delivered on `codex/ifc-performance`; refer to Git history for its commit.

The recorded drawing PDF is absent from the provided file stores. Its full preview remains unverified because no file was available; no placeholder or fabricated drawing was added.
