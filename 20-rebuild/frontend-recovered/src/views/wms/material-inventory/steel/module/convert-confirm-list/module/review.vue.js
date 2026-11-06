import { ref as u } from "vue";
import { watch as F } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as m } from "vue";
import { createBlock as g } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as s } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as H } from "vue";
import { unref as b } from "vue";
import { createElementVNode as P } from "vue";
import { withDirectives as U } from "vue";
import { createElementBlock as L } from "vue";
import { isRef as M } from "vue";
import { ElMessage as x } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElDescriptionsItem as G } from "element-plus";
import { ElDescriptions as J } from "element-plus";
import { ElDivider as K } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { _ as X, u as Y, au as Z, o as ee, z8 as ae, cO as te, jl as le, z as oe, ba as se, jN as ne, z9 as re, za as ie } from "../../../../../../../shared/runtime.js";
import { _ as ce } from "../../../../../../../modules/review-confirm-button-aa3600ad.js";
const ue = { key: 0 }, de = { key: 1 }, me = { __name: "review", props: { detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue", "refresh"], setup(D, { emit: T }) {
  const v = T, d = D, { visible: w, handleClose: _ } = Y({ emit: v, props: d }), h = u(false), a = u({}), p = u(false), f = u(false), k = u(), j = u([["project", "parse-project"], ["quantity", ["to-fixed-field", "measurePrecision"]], ["mete", ["to-fixed-field", "accountingPrecision"]], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["boolOutbound", ["parse-enum", Z]]]), { maxHeight: E } = ee({ mainBox: ".convert-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, k);
  function B(n) {
    return se(n, { props: ["quantity", ["mete", ne.weight.precision]] });
  }
  F(() => d.detailInfo, (n) => {
    n.id && I();
  }, { deep: true, immediate: true });
  async function I() {
    a.value = {}, h.value = true;
    try {
      const n = await ae(d.detailInfo.id);
      a.value = n || {}, a.value.widthThick = a.value.thickness || a.value.width ? (a.value.thickness || "-") + "*" + (a.value.width || "-") : "-", await te(a.value.convertDetailDTOList), a.value.convertDetailDTOList = await le(a.value.convertDetailDTOList, { toSmallest: false, toNum: true });
    } catch (n) {
      console.log(n);
    } finally {
      h.value = false;
    }
  }
  async function O() {
    try {
      p.value = true, await re(d.detailInfo.id), x.success("通过成功"), v("refresh"), _();
    } catch (n) {
      console.log("通过提交", n);
    } finally {
      p.value = false;
    }
  }
  async function S() {
    try {
      f.value = true, await ie(d.detailInfo.id), x.success("退回成功"), v("refresh"), _();
    } catch (n) {
      console.log("退回", n);
    } finally {
      f.value = false;
    }
  }
  return (n, o) => {
    const y = $, i = G, V = J, R = K, l = Q, C = N("common-table"), q = N("common-drawer"), z = W;
    return m(), g(q, { ref_key: "detailRef", ref: k, "append-to-body": "", "close-on-click-modal": false, "before-close": b(_), modelValue: b(w), "onUpdate:modelValue": o[2] || (o[2] = (c) => M(w) ? w.value = c : null), title: "审核", "wrapper-closable": false, size: "85%", "custom-class": "convert-detail" }, { titleAfter: t(() => [e(y, { type: "success" }, { default: t(() => [s("条板转换单：" + r(a.value.receiptSerialNumber), 1)]), _: 1 }), a.value.boolPartyA ? (m(), g(y, { key: 0, type: "danger" }, { default: t(() => o[3] || (o[3] = [s("甲供")])), _: 1, __: [3] })) : H("", true)]), titleRight: t(() => [e(ce, { "passed-loading": p.value, "onUpdate:passedLoading": o[0] || (o[0] = (c) => p.value = c), "returned-loading": f.value, "onUpdate:returnedLoading": o[1] || (o[1] = (c) => f.value = c), "passed-fn": O, "returned-fn": S }, null, 8, ["passed-loading", "returned-loading"])]), content: t(() => [e(y, { effect: "plain" }, { default: t(() => o[4] || (o[4] = [s("原物料信息")])), _: 1, __: [4] }), e(V, { column: 3, border: "", style: { margin: "10px 0" } }, { default: t(() => [e(i, { "label-class-name": "contractLabel", label: "物料名称" }, { default: t(() => [s(r(a.value.classifyName || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "物料编号" }, { default: t(() => [s(r(a.value.serialNumber || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "规格" }, { default: t(() => [s(r(a.value.specification || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "厚(mm)*宽(mm)" }, { default: t(() => [s(r(a.value.widthThick || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "品牌" }, { default: t(() => [s(r(a.value.brand || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "颜色" }, { default: t(() => [s(r(a.value.color || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "卷号" }, { default: t(() => [s(r(a.value.heatNoAndBatchNo || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "项目" }, { default: t(() => [s(r(a.value.project ? b(oe)(a.value.project) : "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "仓库" }, { default: t(() => {
      var c;
      return [s(r(((c = a.value.warehouse) == null ? void 0 : c.name) || "-"), 1)];
    }), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "备注" }, { default: t(() => [s(r(a.value.remark || "-"), 1)]), _: 1 })]), _: 1 }), e(R, null, { default: t(() => o[5] || (o[5] = [P("span", { class: "title" }, "转换后物料信息", -1)])), _: 1, __: [5] }), U((m(), g(C, { data: a.value.convertDetailDTOList, "data-format": j.value, "show-summary": "", "summary-method": B, "max-height": b(E) - 220 }, { default: t(() => [e(l, { label: "序号", type: "index", align: "center", width: "60" }, { default: t(({ row: { sourceRow: c }, $index: A }) => [c.boolSurplus ? (m(), L("span", ue, "余料")) : (m(), L("span", de, r(A + 1), 1))]), _: 1 }), e(l, { key: "serialNumber", prop: "serialNumber", label: "物料编号", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "length", prop: "length", label: "长(mm)", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "width", prop: "width", label: "宽(mm)", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "thickness", prop: "thickness", label: "厚(mm)", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "quantity", prop: "quantity", label: "数量（张）", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "mete", prop: "mete", label: "重量（kg）", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "project", prop: "project", label: "所属项目", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), e(l, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "workshopName", prop: "workshopName", label: "车间", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "warehouse.name", prop: "warehouse.name", label: "仓库", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "recipientName", prop: "recipientName", label: "领用人", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "outboundTime", prop: "outboundTime", label: "出库时间", align: "center", "show-overflow-tooltip": "", width: "150" }), e(l, { key: "boolOutbound", prop: "boolOutbound", label: "是否出库", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[z, h.value]])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, ve = X(me, [["__scopeId", "data-v-9d57609b"]]);
export {
  ve as default
};
