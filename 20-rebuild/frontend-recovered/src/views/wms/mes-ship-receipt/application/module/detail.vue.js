import { inject as F } from "vue";
import { ref as u } from "vue";
import { computed as g } from "vue";
import { watch as U } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as w } from "vue";
import { createBlock as x } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as o } from "vue";
import { unref as d } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as s } from "vue";
import { withDirectives as I } from "vue";
import { createElementBlock as z } from "vue";
import { createCommentVNode as M } from "vue";
import { isRef as O } from "vue";
import { ElDivider as W } from "element-plus";
import { ElDescriptionsItem as K } from "element-plus";
import { ElDescriptions as X } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { r as Q } from "../../../../../modules/mes-ship-receipt-ae6ae43f.js";
import { _ as Y, jX as Z, qS as $, o as ee, u as ae, cO as te, jl as oe, i as le, z as ne, pA as se, ba as re } from "../../../../../shared/runtime.js";
const ie = { class: "extra-detail-content" }, ce = { key: 0 }, de = { style: { color: "#409eff" } }, me = { style: { color: "#409eff" } }, ue = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) }, showType: { type: String, default: "detail" } }, emits: ["refresh", "update:modelValue"], setup(r, { emit: k }) {
  const j = k, h = F("globalProject"), y = r, L = u(), p = u(false), b = u([]), N = u(false), D = u([]), B = u([...Z, ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]], ["outboundAddress", ["parse-enum", $]]]), T = g(() => "详情"), { maxHeight: V } = ee({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header", ".extra-detail-content"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => g(() => !p.value)), { visible: f, handleClose: C } = ae({ emit: j, props: y, closeHook: S });
  U(f, async (m) => {
    m && await R();
  }, { immediate: true });
  async function R() {
    b.value = [];
    const m = y.data.id;
    if (m) try {
      p.value = true;
      const n = await Q(m) || [];
      await te(n), await oe(n, { toSmallest: false, toNum: false }), b.value = n || [];
    } catch (n) {
      console.log("加载失败", n);
    } finally {
      p.value = false;
    }
  }
  function S() {
  }
  function E(m) {
    return re(m, { props: ["quantity", "mete"] });
  }
  return (m, n) => {
    const _ = W, i = K, H = X, l = G, q = v("common-table"), A = v("common-drawer"), P = J;
    return w(), x(A, { ref_key: "drawerRef", ref: L, modelValue: d(f), "onUpdate:modelValue": n[0] || (n[0] = (t) => O(f) ? f.value = t : null), "content-loading": p.value, "before-close": d(C), title: T.value, "show-close": true, "close-on-click-modal": false, size: "100%", "custom-class": "raw-mat-application-review-form" }, { titleAfter: a(() => [c("span", null, "项目名称:" + o(d(le)(d(h)) ? d(ne)(d(h)) : "-"), 1)]), titleRight: a(() => n[1] || (n[1] = [])), content: a(() => [c("div", ie, [e(_, null, { default: a(() => n[2] || (n[2] = [c("span", { class: "title" }, "配套件详情", -1)])), _: 1, __: [2] }), e(H, { column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: a(() => [e(i, { label: "名称", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.name), 1)]), _: 1 }), e(i, { label: "规格", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.specification || "-"), 1)]), _: 1 }), e(i, { label: "单体", "label-class-name": "contractLabel" }, { default: a(() => {
      var t;
      return [s(o(((t = r.data.monomer) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), e(i, { label: "区域", "label-class-name": "contractLabel" }, { default: a(() => {
      var t;
      return [s(o(((t = r.data.area) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), e(i, { label: "核算单位", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.accountingUnit || "-"), 1)]), _: 1 }), e(i, { label: "核算量", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.mete || "-"), 1)]), _: 1 }), e(i, { label: "使用范围", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.useProperty || "-"), 1)]), _: 1 }), e(i, { label: "导入人", "label-class-name": "contractLabel" }, { default: a(() => {
      var t;
      return [s(o(((t = r.data.applicant) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), e(i, { label: "导入时间", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.createTime || "-"), 1)]), _: 1 }), e(i, { label: "已出库量", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.totalCargoNetweight || "-"), 1)]), _: 1 }), e(i, { label: "备注", "label-class-name": "contractLabel" }, { default: a(() => [s(o(r.data.remark || "-"), 1)]), _: 1 })]), _: 1 }), e(_, null, { default: a(() => n[3] || (n[3] = [c("span", { class: "title" }, "物料出库记录", -1)])), _: 1, __: [3] })]), I((w(), x(q, { data: b.value, "data-format": B.value, "max-height": d(V) - 100, "highlight-current-row": "", "show-summary": "", "summary-method": E, "expand-row-keys": D.value, "row-key": "id" }, { default: a(() => [e(l, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), e(l, { key: "outboundTime", prop: "outboundTime", label: "出库时间", align: "center", width: "150" }), e(l, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "", width: "100" }), e(l, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", width: "100" }), e(l, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "150px" }, { default: a(({ row: { sourceRow: t } }) => [c("span", null, o(d(se)(t)), 1)]), _: 1 }), e(l, { key: "brand", align: "left", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "70" }), e(l, { key: "quantity", prop: "quantity", label: "数量", align: "right", "show-overflow-tooltip": "", "min-width": "80px" }, { default: a(({ row: { sourceRow: t } }) => [t.measureUnit ? (w(), z("span", ce, [s(o(t.quantity) + " ", 1), c("span", de, o(t.measureUnit), 1)])) : M("", true)]), _: 1 }), e(l, { key: "mete", prop: "mete", label: "核算量", align: "right", "show-overflow-tooltip": "", "min-width": "80px" }, { default: a(({ row: { sourceRow: t } }) => [c("span", null, [s(o(t.mete) + " ", 1), c("span", me, o(t.accountingUnit), 1)])]), _: 1 }), e(l, { key: "sourceProject", prop: "sourceProject", label: "原项目", align: "center", "show-overflow-tooltip": "", "min-width": "150px" }), e(l, { key: "warehouse.name", prop: "warehouse.name", label: "所属仓库", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), e(l, { key: "outboundAddress", prop: "outboundAddress", label: "目的地", align: "center", "show-overflow-tooltip": "", width: "80px" }), e(l, { key: "project", prop: "project", label: "领用项目", align: "center", "show-overflow-tooltip": "", "min-width": "150px" }), e(l, { key: "mesWorkshop.name", prop: "mesWorkshop.name", label: "领用车间", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), e(l, { key: "recipientName", prop: "recipientName", label: "领用人", align: "center", "show-overflow-tooltip": "", width: "90px" }), e(l, { key: "remark", prop: "remark", label: "备注", align: "center", "show-overflow-tooltip": "", width: "90px" }), e(l, { key: "outboundSerialNumber", prop: "outboundSerialNumber", label: "出库单号", align: "center", "show-overflow-tooltip": "", "min-width": "80px" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[P, N.value]])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, we = Y(ue, [["__scopeId", "data-v-880ccafb"]]);
export {
  we as default
};
