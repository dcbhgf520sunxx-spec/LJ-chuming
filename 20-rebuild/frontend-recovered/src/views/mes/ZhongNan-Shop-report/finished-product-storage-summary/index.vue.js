import { ref as w } from "vue";
import { provide as _ } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as f } from "vue";
import { unref as i } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as n } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as a } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as q } from "../../../../modules/finished-product-storage-summary-8160e784.js";
import { m$ as b, o as R, x as V, G as $ } from "../../../../shared/runtime.js";
import N from "./module/header.vue.js";
import S from "./module/detail.vue.js";
const A = { class: "app-container" }, E = { class: "head-container" }, J = { __name: "index", setup(U) {
  const v = w(), P = w(false), m = w({});
  _("permission", b);
  const { maxHeight: y } = R({ extraBox: [".head-container"], paginate: false }), x = { add: false, edit: false, del: false, download: false }, { crud: c, columns: s } = V({ title: "成品入库汇总", permission: { ...b }, optShow: { ...x }, crudApi: { ...q }, dataPath: "", hasPagination: false, queryOnPresenterCreated: false }, v);
  function M(h) {
    P.value = true, m.value = h;
  }
  function k({ columnIndex: h, row: p, column: o, rowIndex: g }) {
    if (p.structureType === "合计") {
      if (h === 0) return [1, 0];
      if (h === 1) return [1, 2];
    }
  }
  return _("query", c.query), (h, p) => {
    const o = B, g = F("common-button"), C = F("common-table"), H = O;
    return l(), T("div", A, [u("div", E, [f(i(N), { ref: "headerRef" }, null, 512)]), D((l(), n(C, { ref_key: "tableRef", ref: v, data: i(c).data, "empty-text": i(c).emptyText, "max-height": i(y), "span-method": k, style: { width: "100%" } }, { default: r(() => [f(o, { label: "序号", type: "index", align: "center", width: "60" }), i(s).visible("structureType") ? (l(), n(o, { label: "构件类别", prop: "structureType", key: "structureType", align: "center", "min-width": "120" }, { default: r((e) => [u("span", null, d(e.row.structureType), 1)]), _: 1 })) : a("", true), i(s).visible("beginPutPart") ? (l(), n(o, { label: "期初累计情况", prop: "beginPutPart", key: "beginPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r(() => [i(s).visible("beginPutPart") ? (l(), n(o, { label: "已投料数量", prop: "beginPutPart", key: "beginPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.beginPutPart) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true), i(s).visible("beginFinishProduct") ? (l(), n(o, { label: "已完工产量", prop: "beginFinishProduct", key: "beginFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.beginFinishProduct) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true)]), _: 1 })) : a("", true), i(s).visible("beginHalfProduct") ? (l(), n(o, { label: "期初半成品", prop: "beginHalfProduct", key: "beginHalfProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r(() => [i(s).visible("beginHalfProduct") ? (l(), n(o, { label: "半成品总吨位", prop: "beginHalfProduct", key: "beginHalfProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.beginHalfProduct) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true), i(s).visible("beginConvertFinishProduct") ? (l(), n(o, { label: "折合完工产量", prop: "beginConvertFinishProduct", key: "beginConvertFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.beginConvertFinishProduct) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true)]), _: 1 })) : a("", true), i(s).visible("thisMonthPutPart") ? (l(), n(o, { label: "本月投料(T)", prop: "thisMonthPutPart", key: "thisMonthPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.thisMonthPutPart) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true), i(s).visible("thisMonthFinishProduct") ? (l(), n(o, { label: "本月入库产量(T)", prop: "thisMonthFinishProduct", key: "thisMonthFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.thisMonthFinishProduct) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true), i(s).visible("thisMonthHalfProduct") ? (l(), n(o, { label: "期末半成品", prop: "thisMonthHalfProduct", key: "thisMonthHalfProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r(() => [i(s).visible("thisMonthHalfProduct") ? (l(), n(o, { label: "半成品总吨位", prop: "thisMonthHalfProduct", key: "thisMonthHalfProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.thisMonthHalfProduct) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true), i(s).visible("thisMonthConvertFinishProduct") ? (l(), n(o, { label: "折合完工产量", prop: "thisMonthConvertFinishProduct", key: "thisMonthConvertFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.thisMonthConvertFinishProduct) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true)]), _: 1 })) : a("", true), i(s).visible("totalPutPart") ? (l(), n(o, { label: "累计情况", prop: "totalPutPart", key: "totalPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r(() => [i(s).visible("totalPutPart") ? (l(), n(o, { label: "已投料数量", prop: "totalPutPart", key: "totalPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.totalPutPart) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true), i(s).visible("totalFinishProduct") ? (l(), n(o, { label: "已完工产量", prop: "totalFinishProduct", key: "totalFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.totalFinishProduct) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true)]), _: 1 })) : a("", true), i(s).visible("thisMonthFinishOutput") ? (l(), n(o, { label: "本月完工产量", prop: "thisMonthFinishOutput", key: "thisMonthFinishOutput", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: r((e) => {
      var t;
      return [u("div", null, d((t = e.row.thisMonthFinishOutput) == null ? void 0 : t.toFixed(3)), 1)];
    }), _: 1 })) : a("", true), f(o, { label: "操作", align: "center", fixed: "right" }, { default: r((e) => [e.row.structureType !== "合计" && i($)(i(b).detail) ? (l(), n(g, { key: 0, type: "primary", size: "default", icon: "el-icon-view", onClick: (t) => M(e.row) }, null, 8, ["onClick"])) : a("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, i(c).loading]]), f(i(S), { visible: P.value, "onUpdate:visible": p[0] || (p[0] = (e) => P.value = e), "row-detail": m.value }, null, 8, ["visible", "row-detail"])]);
  };
} };
export {
  J as default
};
