import f from "./module/header.vue.js";
import m from "./module/table.vue.js";
import { u } from "../../../../modules/useSelect-654af12a.js";
import { useStore as _ } from "vuex";
import { ref as a } from "vue";
import { provide as d } from "vue";
import { watch as h } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as s } from "vue";
import "../../../../shared/runtime.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/self-healing-6f411a5c.js";
import "../../../../modules/contract-9b18cc88.js";
import "../../../../modules/useTableTotal-3d22365a.js";
const y = { class: "app-container" }, E = { __name: "index", setup(R, { expose: l }) {
  const c = _(), n = a({ year: (/* @__PURE__ */ new Date()).getTime() }), { projectLeaderList: i } = u(), o = a(null), r = a(null), p = a({});
  return d("selfParentData", { formData: n, headerRef: o, tableRef: r, projectLeaderList: i, _commonFn: p }), h(() => c.state.approval_list.isRefresh, (t) => {
    var e;
    t && ((e = r.value) == null || e.getSelfProjectList());
  }, { deep: true }), l({ refresh: async () => {
    var t, e;
    await ((t = r.value) == null ? void 0 : t.getSelfProjectList()), await ((e = o.value) == null ? void 0 : e.getSelfEmployed());
  } }), (t, e) => (v(), w("div", y, [s(f, { ref_key: "headerRef", ref: o }, null, 512), s(m, { ref_key: "tableRef", ref: r }, null, 512)]));
} };
export {
  E as default
};
