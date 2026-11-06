import { inject as y } from "vue";
import { provide as f } from "vue";
import { ref as r } from "vue";
import { computed as h } from "vue";
import { watch as I } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as p } from "vue";
import { unref as a } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as c } from "vue";
import { vShow as d } from "vue";
import { pp as x, m as b, b as u } from "../../../../shared/runtime.js";
import g from "./summary-list/index.vue.js";
import j from "./detail-list/index.vue.js";
import "../../../../modules/wage-adjust-5476478d.js";
import "./summary-list/module/header.vue.js";
import "../../../../modules/mes-ee117a22.js";
import "./detail-list/module/header.vue.js";
import "./module/edit-dialog.vue.js";
import "../../../../modules/use-table-change-32e98420.js";
import "./module/edit-preview.vue.js";
import "../../../../modules/index-61ce89a1.js";
const P = { style: { display: "flex" } }, B = { class: "app-container" }, M = { __name: "index", setup(Q) {
  const v = y("permission", x);
  f("permission", v);
  const o = r(), n = r(), l = h(() => {
    var e;
    return (e = o == null ? void 0 : o.value) == null ? void 0 : e.query;
  }), { globalProjectId: m } = b("globalProjectId");
  f("projectId", m);
  const s = r();
  I([() => {
    var e;
    return (e = l.value) == null ? void 0 : e.taskTypeEnum;
  }, () => m.value], (e) => {
    s.value = void 0;
  });
  function _(e) {
    var t;
    s.value = e, (t = n.value) == null || t.fetchProcess(e);
  }
  return (e, t) => (k(), w("div", P, [p(a(g), { style: { width: "32%" }, ref_key: "summaryListRef", ref: o, onSetInfo: _ }, null, 512), t[1] || (t[1] = i("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 100px)" } }, null, -1)), c(i("div", B, t[0] || (t[0] = [i("div", { class: "my-code" }, "点击左表操作", -1)]), 512), [[d, a(u)(s.value)]]), c(p(a(j), { ref_key: "detailListRef", ref: n, style: { width: "67%" }, fQuery: l.value, fInfo: s.value }, null, 8, ["fQuery", "fInfo"]), [[d, !a(u)(s.value)]])]));
} };
export {
  M as default
};
