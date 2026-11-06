import { ref as p } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as y } from "vue";
import { createBlock as k } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as N } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as l } from "vue";
import { withDirectives as L } from "vue";
import { unref as m } from "vue";
import { isRef as Q } from "vue";
import { ElTag as z } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { vLoading as S } from "element-plus";
import { g as q } from "../../../../../modules/feedstock-reporting-f416c9a5.js";
import { u as A, o as O } from "../../../../../shared/runtime.js";
const J = { __name: "detail", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(x, { emit: B }) {
  const V = B, f = x, g = p(), _ = p([]), d = p(false), u = p(), { visible: c, handleClose: H } = A({ emit: V, props: f, field: "visible", showHook: T, closeHook: R }), { maxHeight: C } = O({ mainBox: ".feedstock-reporting-detail", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, g);
  function T() {
    D();
  }
  async function D() {
    var t;
    d.value = true;
    let i = {};
    try {
      i = await q({ id: (t = f.currentRow) == null ? void 0 : t.id }) || [];
    } catch (r) {
      console.log("获取详情", r);
    } finally {
      d.value = false, u.value = i || {}, _.value = (i == null ? void 0 : i.detailList) || [];
    }
  }
  function R() {
  }
  return (i, t) => {
    const r = z, s = M, j = v("common-table"), E = v("common-dialog"), I = S;
    return y(), k(E, { ref_key: "dialogVisible", ref: g, title: "投料详情", modelValue: m(c), "onUpdate:modelValue": t[0] || (t[0] = (e) => Q(c) ? c.value = e : null), "before-close": m(H), top: "10vh", width: "70%", customClass: "feedstock-reporting-detail" }, { titleAfter: a(() => [o(r, { size: "default", effect: "plain" }, { default: a(() => {
      var e, w, b, h;
      return [t[1] || (t[1] = N(" 投料项目： ")), n("span", null, l((w = (e = u.value) == null ? void 0 : e.project) == null ? void 0 : w.serialNumber) + " " + l(((h = (b = u.value) == null ? void 0 : b.project) == null ? void 0 : h.shortName) || "-"), 1)];
    }), _: 1, __: [1] }), o(r, { size: "default", effect: "plain" }, { default: a(() => {
      var e;
      return [t[2] || (t[2] = N(" 办理人： ")), n("span", null, l((e = u.value) == null ? void 0 : e.userName), 1)];
    }), _: 1, __: [2] })]), default: a(() => [L((y(), k(j, { ref: "tableRef", data: _.value, "empty-text": "暂无数据", "max-height": m(C), showEmptySymbol: false, style: { width: "100%" } }, { default: a(() => [o(s, { label: "序号", type: "index", align: "center", width: "60" }), o(s, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", label: "单体", align: "center" }, { default: a((e) => [n("span", null, l(e.row.monomerName || "-"), 1)]), _: 1 }), o(s, { key: "areaBatchName", prop: "areaBatchName", "show-overflow-tooltip": "", label: "批次", align: "center" }, { default: a((e) => [n("span", null, l(e.row.areaBatchName || "-"), 1)]), _: 1 }), o(s, { key: "structureType", prop: "structureType", "show-overflow-tooltip": "", label: "构件类别", align: "center" }, { default: a((e) => [n("span", null, l(e.row.structureType || "-"), 1)]), _: 1 }), o(s, { key: "feedingQuantity", prop: "feedingQuantity", "show-overflow-tooltip": "", label: "本次投料量(kg)", align: "center" }, { default: a((e) => [n("span", null, l(e.row.feedingQuantity ?? "-"), 1)]), _: 1 }), o(s, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": "", label: "生产车间", align: "center" }, { default: a((e) => [n("span", null, l(e.row.workshopName || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[I, d.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
