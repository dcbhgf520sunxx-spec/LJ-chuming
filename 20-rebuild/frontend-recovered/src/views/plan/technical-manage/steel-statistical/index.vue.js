import { ref as P } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as k } from "vue";
import { unref as a } from "vue";
import { Fragment as H } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as v } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as i } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as n } from "vue";
import { normalizeClass as R } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as V } from "element-plus";
import { l as q, _ as A, m as O, x as T, o as U } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import { H as G } from "../../../../modules/plan-d12d7ccf.js";
function K(b) {
  return q({ url: "/api/steel/analysis", method: "get", params: b });
}
const L = { get: K };
const Q = { class: "app-container" }, $ = { class: "head-container" }, J = { __name: "index", setup(b) {
  const { globalProject: M, globalProjectId: C } = O(["globalProject", "globalProjectId"]), N = { add: false, edit: false, del: false, download: false }, y = P(), { crud: _, columns: d, CRUD: j } = T({ title: "钢材使用用量对比", sort: ["id.desc"], permission: { ...G }, optShow: { ...N }, requiredQuery: ["projectId"], crudApi: { ...L }, hasPagination: false }, y), { maxHeight: S } = U({ wrapperBox: ".steel-statistical", paginate: true, extraHeight: 40 });
  j.HOOK.handleRefresh = (h, u) => {
    u.data.content = u.data.content.map((t) => (t.diffClass = t.diff && t.diff >= 0 ? "green" : "red", t.diffRateClass = t.diffRate && t.diffRate >= 0 ? "green" : "red", t.diffRate = (t.diffRate * 100).toFixed(2) + "%", t));
  };
  function D(h) {
    const { columns: u, data: t } = h, s = [], w = ["listMete", "stockMete", "diff", "diffRate"], e = {};
    return u.forEach((m, f) => {
      if (f === 0) {
        s[f] = "合计";
        return;
      }
      if (!w.includes(m.property)) return;
      const g = t.map((c) => Number(c[m.property]));
      g.every((c) => isNaN(c)) || (s[f] = g.reduce((c, x) => {
        const I = Number(x);
        return isNaN(I) ? c : c + x;
      }, 0), e[m.property] = s[f]), m.property === "diffRate" ? s[f] = Number(e.diff) && Number(e.listMete) ? (e.diff / e.listMete * 100).toFixed(2) + "%" : "-" : s[f] = Number(s[f]).toFixed(2);
    }), s;
  }
  return (h, u) => {
    const t = F, s = B("common-table"), w = V;
    return o(), k("div", Q, [a(M) ? (o(), k(H, { key: 0 }, [r("div", $, [v(a(z), { projectId: a(C) }, null, 8, ["projectId"])]), E((o(), i(s, { ref_key: "tableRef", ref: y, data: a(_).data, "empty-text": a(_).emptyText, "max-height": a(S), style: { width: "100%" }, "show-summary": "", "summary-method": D, "return-source-data": "", showEmptySymbol: false }, { default: l(() => [v(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(d).visible("name") ? (o(), i(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "钢材种类", width: "140px" }, { default: l((e) => [r("span", null, p(e.row.name), 1)]), _: 1 })) : n("", true), a(d).visible("thickness") ? (o(), i(t, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: "厚度/规格", "min-width": "160px" }, { default: l((e) => [r("span", null, p(e.row.thickness), 1)]), _: 1 })) : n("", true), a(d).visible("material") ? (o(), i(t, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "160px" }, { default: l((e) => [r("span", null, p(e.row.material), 1)]), _: 1 })) : n("", true), a(d).visible("listMete") ? (o(), i(t, { key: "listMete", prop: "listMete", "show-overflow-tooltip": true, label: "清单量(kg)", "min-width": "160px" }, { default: l((e) => [r("span", null, p(e.row.listMete), 1)]), _: 1 })) : n("", true), a(d).visible("stockMete") ? (o(), i(t, { key: "stockMete", prop: "stockMete", "show-overflow-tooltip": true, label: "当前库存(kg)", "min-width": "160px" }, { default: l((e) => [r("span", null, p(e.row.stockMete), 1)]), _: 1 })) : n("", true), a(d).visible("diff") ? (o(), i(t, { key: "diff", prop: "diff", "show-overflow-tooltip": true, label: "差异", "min-width": "160px" }, { default: l((e) => [r("span", { class: R(e.row.diffClass) }, p(e.row.diff), 3)]), _: 1 })) : n("", true), a(d).visible("diffRate") ? (o(), i(t, { key: "diffRate", prop: "diffRate", "show-overflow-tooltip": true, label: "差异率", "min-width": "160px" }, { default: l((e) => [r("span", { class: R(e.row.diffRateClass) }, p(e.row.diffRate), 3)]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[w, a(_).loading]])], 64)) : n("", true)]);
  };
} }, ee = A(J, [["__scopeId", "data-v-d47adf51"]]);
export {
  ee as default
};
