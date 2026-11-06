import { ref as y } from "vue";
import { watch as I } from "vue";
import { resolveComponent as j } from "vue";
import { withDirectives as b } from "vue";
import { vShow as D } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as l } from "vue";
import { withCtx as w } from "vue";
import { createTextVNode as M } from "vue";
import { withKeys as H } from "vue";
import { createBlock as U } from "vue";
import { toDisplayString as K } from "vue";
import { unref as n } from "vue";
import { ElTag as O } from "element-plus";
import { ElInput as F } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { vLoading as R } from "element-plus";
import { t as A } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { o as G, J as W, on as X, c as C, D as Y } from "../../../../../../shared/runtime.js";
const Z = { style: { "margin-top": "20px" } }, $ = { class: "head-container" }, oe = { __name: "train-number-list", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, category: { type: Number }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(S, { expose: T }) {
  const E = y([["loadingTime", ["parse-time", "{y}-{m}-{d}"]]]), r = S, f = y([]), d = y(false), h = y({}), { maxHeight: k } = G({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: z, handleCurrentChange: P, total: L, setTotalPage: V, queryPage: _ } = W({ fetchHook: m });
  I(() => r.showType, (a) => {
    a && (h.value = {}, m());
  }, { immediate: true, deep: true });
  async function m() {
    if (f.value = [], !!r.showType) {
      d.value = true;
      try {
        const { content: a = [], totalElements: o } = await A({ projectId: r.projectId, ...r.query, workshopId: r.workshopId, shipEnumType: X[r.showType].V, ..._, ...h.value });
        f.value = a, V(o), d.value = false;
      } catch (a) {
        console.log("获取详情失败", a), d.value = false;
      }
    }
  }
  function B(a) {
    const { columns: o, data: g } = a, u = [];
    return o.forEach((t, p) => {
      if (p === 0) {
        u[p] = "合计";
        return;
      }
      if (t.property === "quantity") {
        const s = g.map((e) => Number(e[t.property]));
        let i = 0;
        s.every((e) => isNaN(e)) || (i = s.reduce((e, c) => {
          const v = Number(c);
          return isNaN(v) ? e : e + c;
        }, 0)), u[p] = i;
      }
      if (t.property === "totalLength") {
        const s = g.map((e) => Number(e[t.property]));
        let i = 0;
        s.every((e) => isNaN(e)) || (i = s.reduce((e, c) => {
          const v = Number(c);
          return isNaN(v) ? e : e + c;
        }, 0)), u[p] = C(i, "mm", "m", 2);
      }
    }), u;
  }
  return T({ refresh: m }), (a, o) => {
    const g = O, u = F, t = J, p = j("common-table"), s = Q, i = R;
    return b((N(), q("div", Z, [x("div", $, [l(g, { size: "default", class: "filter-item" }, { default: w(() => o[1] || (o[1] = [M("累计车次/船次")])), _: 1, __: [1] }), l(u, { modelValue: h.value.licensePlate, "onUpdate:modelValue": o[0] || (o[0] = (e) => h.value.licensePlate = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入车牌/船牌号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: H(m, ["enter"]), onChange: m }, null, 8, ["modelValue"])]), b((N(), U(p, { data: f.value, "show-empty-symbol": false, "show-summary": "", "data-format": E.value, "summary-method": B, "max-height": n(k) - 140 }, { default: w(() => [l(t, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), l(t, { "show-overflow-tooltip": "", prop: "loadingTime", key: "loadingTime", label: "发运日期", align: "center" }), l(t, { key: "serialNumber", prop: "serialNumber", label: "车次/船次号", align: "center", "show-overflow-tooltip": true }), l(t, { key: "licensePlate", prop: "licensePlate", label: "车牌/船牌号", align: "center", "show-overflow-tooltip": true }), l(t, { key: "totalLength", prop: "totalLength", label: "总长（m）", align: "center", "show-overflow-tooltip": true }, { default: w(({ row: e }) => [x("span", null, K(n(C)(e.totalLength, "mm", "m", n(Y).MES_ENCLOSURE_L__M) || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[i, d.value]]), l(s, { total: n(L), "current-page": n(_).pageNumber, "page-size": n(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(z), onCurrentChange: n(P) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512)), [[D, r.showType]]);
  };
} };
export {
  oe as default
};
