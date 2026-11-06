import { ref as l } from "vue";
import { provide as w } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as q } from "vue";
import { createVNode as y } from "vue";
import { unref as p } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as N } from "vue";
import { withCtx as b } from "vue";
import { toDisplayString as I } from "vue";
import { Fragment as A } from "vue";
import { renderList as O } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as Q, g as F } from "../../../../modules/work-in-progress-statistics-5c372d83.js";
import { a as K } from "../../../../modules/common-f216149e.js";
import { _ as M, x as Y, sv as $, o as z, sw as d } from "../../../../shared/runtime.js";
import J from "./module/header.vue.js";
import X from "./module/details.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Z = { class: "app-container" }, ee = { class: "head-container" }, te = ["onClick"], se = { key: 1 }, oe = { __name: "index", setup(re) {
  const T = l(), { crud: a, CRUD: x } = Y({ title: "在制品统计", permission: { ...$ }, crudApi: { ...Q }, sort: [], dataPath: "statisticsList", hasPagination: false }, T), k = l(), S = l({}), L = l({}), h = l(false), m = l({ yesterdaySInventory: void 0, growthWeight: void 0, rate: void 0 }), _ = l([]), { maxHeight: C } = z({ paginate: false });
  async function V(o) {
    try {
      _.value = await F(a == null ? void 0 : a.query);
    } catch (t) {
      console.log(t);
    }
  }
  x.HOOK.beforeToQuery = () => {
    V();
  }, x.HOOK.handleRefresh = (o, t) => {
    var r, s, c;
    m.value.yesterdaySInventory = ((r = t.data) == null ? void 0 : r.yesterdaySInventory) || 0, m.value.rate = ((s = t.data) == null ? void 0 : s.rate) || 0, m.value.growthWeight = ((c = t.data) == null ? void 0 : c.growthWeight) || 0;
  };
  function g(o, t) {
    var s;
    const r = (s = o.processWipList) == null ? void 0 : s.find((c) => c.processId === t.processId);
    if (r) switch (a.query.showType) {
      case d.WEIGHT.V:
        return r.weight;
      case d.QUANTITY.V:
        return r.quantity;
      default:
        return;
    }
  }
  async function W() {
    try {
      const { content: o } = await K();
      k.value = o;
    } catch (o) {
      console.log(o);
    }
  }
  W();
  const E = (o) => {
    const { columns: t, data: r } = o, s = [];
    return t.forEach((c, e) => {
      if (e === 0) {
        s[e] = "总合计";
        return;
      }
      const i = _.value.find((n) => n.processId.toString() === c.property);
      if (i) {
        let n = 0;
        r.forEach((R) => {
          var P;
          const v = (P = R.processWipList) == null ? void 0 : P.find((B) => B.processId === i.processId);
          v && (a.query.showType === d.WEIGHT.V ? n += Number(v.weight) || 0 : a.query.showType === d.QUANTITY.V && (n += Number(v.quantity) || 0));
        }), a.query.showType === d.WEIGHT.V ? s[e] = n ? n.toFixed(3) : "0.000" : s[e] = n ? n.toString() : "0";
      } else s[e] = "";
    }), s;
  };
  w("branchList", k), w("summaryInfo", m), w("query", a.query);
  function H(o, t) {
    h.value = true, S.value = o, L.value = t;
  }
  return (o, t) => {
    const r = j, s = D("common-table"), c = G;
    return u(), f("div", Z, [q("div", ee, [y(p(J))]), U((u(), N(s, { ref_key: "tableRef", ref: T, data: p(a).data, "empty-text": p(a).emptyText, "max-height": p(C), "return-source-data": "", "show-empty-symbol": false, "summary-method": E, "show-summary": "", style: { width: "100%" } }, { default: b(() => [y(r, { label: "序号", type: "index", align: "center", width: "60" }), y(r, { label: "项目", prop: "projectName", key: "projectName", align: "center", "min-width": "140" }, { default: b((e) => [q("span", null, I(e.row.projectName || "-"), 1)]), _: 1 }), (u(true), f(A, null, O(_.value, (e) => (u(), N(r, { label: e.processName, key: e.processId, prop: e.processId.toString(), align: "center", "show-overflow-tooltip": "" }, { default: b((i) => [g(i.row, e) ? (u(), f("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (n) => H(i.row, e) }, I(g(i.row, e)), 9, te)) : (u(), f("span", se, I(g(i.row, e) ?? "-"), 1))]), _: 2 }, 1032, ["label", "prop"]))), 128))]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[c, p(a).loading]]), y(p(X), { visible: h.value, "onUpdate:visible": t[0] || (t[0] = (e) => h.value = e), currentRow: S.value, currentProcess: L.value }, null, 8, ["visible", "currentRow", "currentProcess"])]);
  };
} }, me = M(oe, [["__scopeId", "data-v-0cc767ab"]]);
export {
  me as default
};
