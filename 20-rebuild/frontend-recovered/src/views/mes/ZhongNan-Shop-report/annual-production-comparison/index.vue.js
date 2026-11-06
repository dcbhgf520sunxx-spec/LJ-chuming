import { ref as M } from "vue";
import { provide as N } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as g } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as i } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as w } from "vue";
import { Fragment as x } from "vue";
import { renderList as S } from "vue";
import { ElTableColumn as V } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as E, _ as F } from "./module/header.vue.js";
import { m_ as v, x as H, o as O } from "../../../../shared/runtime.js";
const q = { class: "app-container" }, U = { class: "head-container" }, G = { __name: "index", setup(W) {
  const d = M();
  N("permission", v);
  const k = ["1 月", "2 月", "3 月", "4 月", "5 月", "6 月", "1-6 月合计", "7 月", "8 月", "9 月", "10 月", "11 月", "12 月", "7-12 月合计", "全年合计"], C = { add: false, edit: false, del: false, download: false }, { crud: s, columns: p } = H({ title: "年度产量对比", permission: { ...v }, optShow: { ...C }, crudApi: { ...E }, dataPath: "", hasPagination: false }, d), { maxHeight: T } = O({ paginate: false });
  function B({ columnIndex: n, row: u, column: o, rowIndex: m }) {
    if (u.structureType === "产量合计") {
      if (n === 0) return [1, 0];
      if (n === 1) return [1, 2];
    }
  }
  return (n, u) => {
    const o = V, m = P("common-table"), D = A;
    return a(), r("div", q, [l("div", U, [g(e(F), { ref: "headerRef" }, null, 512)]), R((a(), i(m, { ref_key: "tableRef", ref: d, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(T), "span-method": B, style: { width: "100%" } }, { default: c(() => [g(o, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("structureType") ? (a(), i(o, { label: "生产线", prop: "structureType", key: "structureType", align: "center", "min-width": "120" }, { default: c((t) => [l("span", null, b(t.row.structureType || "-"), 1)]), _: 1 })) : w("", true), (a(), r(x, null, S(k, (t, _) => (a(), r(x, { key: _ }, [e(p).visible(t) ? (a(), i(o, { label: t, prop: t, key: t, "show-overflow-tooltip": "", align: "center" }, { default: c((L) => {
      var f, h, y;
      return [l("div", null, b(((y = (h = (f = L.row.yearlyOutputComparisonMonthVOList) == null ? void 0 : f[_]) == null ? void 0 : h.totalNetWeight) == null ? void 0 : y.toFixed(3)) ?? "-"), 1)];
    }), _: 2 }, 1032, ["label", "prop"])) : w("", true)], 64))), 64))]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[D, e(s).loading]])]);
  };
} };
export {
  G as default
};
