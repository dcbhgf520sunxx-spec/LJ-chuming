import { ref as u } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as m } from "vue";
import { unref as i } from "vue";
import { withCtx as d } from "vue";
import { createBlock as R } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementVNode as V } from "vue";
import { nextTick as j } from "vue";
import { ElTag as T } from "element-plus";
import { ElTree as B } from "element-plus";
import { p as A } from "../../../../../modules/scheduling-manage-9a6dc016.js";
import { d as P } from "../../../../../modules/enclosure-365a2177.js";
import { x as v, mE as g } from "../../../../../shared/runtime.js";
import K from "./module/header.vue.js";
const L = { class: "app-container" }, F = { __name: "index", emits: ["project-change"], setup(M, { expose: _, emit: D }) {
  const N = D, k = { add: false, edit: false, del: false, download: false }, y = u(), c = u(), S = { children: (e) => e.monomerSchedulingDetailDO ? e.monomerSchedulingDetailDO : e.areaSchedulingDetailDO ? e.areaSchedulingDetailDO : [], label: (e) => {
    if (e.name) return e.name;
    if (e.shortName) return (e == null ? void 0 : e.serialNumber) + "-" + e.shortName;
  } }, { crud: a, CRUD: x } = v({ title: "排产管理-项目列表", sort: [], permission: { ...P }, optShow: { ...k }, crudApi: { get: A }, hasPagination: false }, y);
  function C(e) {
    let t = c.value.getNode(e.id);
    for (; t.level > 1; ) t = t.parent;
    c.value.store._getAllNodes().filter((r) => r.level === 1 && r.id !== t.id).forEach((r) => {
      const o = (l) => {
        var h;
        c.value.setChecked(l, false, true), l.indeterminate = false, (h = l.childNodes) == null || h.forEach((E) => o(E));
      };
      o(r);
    }), j(() => {
      const r = c.value.getCheckedKeys(true);
      N("project-change", r || []);
    });
  }
  return x.HOOK.handleRefresh = async (e, { data: s }) => {
    s == null || s.forEach((t) => {
      Reflect.has(t, "monomerSchedulingDetailDO") && (t.id = t.id + "_1", t.monomerSchedulingDetailDO.forEach((n, r) => {
        Reflect.has(n, "areaSchedulingDetailDO") && (n.id = n.id + "_2");
      }));
    }), s.content = s;
  }, _({ refresh: a.refresh }), (e, s) => {
    const t = T, n = B;
    return f(), O("div", L, [m(i(K), { class: "head-container project-head-container" }), m(n, { ref_key: "treeRef", ref: c, data: i(a).data, props: S, "highlight-current": "", "node-key": "id", "show-checkbox": "", style: { width: "100%" }, onCheck: C }, { default: d(({ node: r, data: o }) => {
      var l;
      return [o != null && o.status ? (f(), R(t, { key: 0, type: (l = i(g).V[o.status]) == null ? void 0 : l.TAG, style: { "margin-right": "5px" } }, { default: d(() => [b(p(i(g).VL[o.status]), 1)]), _: 2 }, 1032, ["type"])) : w("", true), V("span", null, p(r.label), 1)];
    }), _: 1 }, 8, ["data"])]);
  };
} };
export {
  F as default
};
