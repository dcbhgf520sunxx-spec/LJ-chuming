import { ref as d } from "vue";
import { watch as C } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as u } from "vue";
import { createBlock as f } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as o } from "vue";
import { toDisplayString as s } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementVNode as R } from "vue";
import { withDirectives as q } from "vue";
import { createElementBlock as g } from "vue";
import { isRef as H } from "vue";
import { ElTag as P } from "element-plus";
import { ElDescriptionsItem as z } from "element-plus";
import { ElDescriptions as F } from "element-plus";
import { ElDivider as U } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { vLoading as Y } from "element-plus";
import { _ as $, u as G, au as J, D as K, o as Q, z8 as W, cO as X, jl as Z, kD as ee, L as ae, BD as te, z as le, ba as oe, jN as se } from "../../../../../../../../shared/runtime.js";
const ne = { key: 0 }, ie = { key: 1 }, re = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(k, { emit: N }) {
  const D = N, b = k, { visible: _, handleClose: x } = G({ emit: D, props: b }), w = d(false), v = d(), a = d({}), L = d([["project", "parse-project"], ["quantity", ["to-fixed-field", "measurePrecision"]], ["mete", ["to-fixed-field", "accountingPrecision"]], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["boolOutbound", ["parse-enum", J]], ["amountExcludingVat", ["to-thousand", K.YUAN]]]), { maxHeight: E } = Q({ mainBox: ".convert-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, v);
  function T(r) {
    return oe(r, { props: ["quantity", ["mete", se.weight.precision]] });
  }
  C(() => b.detailInfo, (r) => {
    r.id && S();
  }, { deep: true, immediate: true });
  async function S() {
    a.value = {}, w.value = true;
    try {
      const r = await W(b.detailInfo.id);
      a.value = r || {}, a.value.widthThick = a.value.thickness || a.value.width ? (a.value.thickness || "-") + "*" + (a.value.width || "-") : "-", await X(a.value.convertDetailDTOList), a.value.convertDetailDTOList = await Z(a.value.convertDetailDTOList, { toSmallest: false, toNum: true });
    } catch (r) {
      console.log(r);
    } finally {
      w.value = false;
    }
  }
  return (r, n) => {
    const p = P, i = z, V = F, j = U, l = M, B = h("common-table"), O = h("common-drawer"), I = Y;
    return u(), f(O, { ref_key: "detailRef", ref: v, "append-to-body": "", "close-on-click-modal": false, "before-close": m(x), modelValue: m(_), "onUpdate:modelValue": n[0] || (n[0] = (c) => H(_) ? _.value = c : null), title: "详情", "wrapper-closable": false, size: "85%", "custom-class": "convert-detail" }, { titleAfter: t(() => [e(p, { type: "success" }, { default: t(() => [o("条板转换单：" + s(a.value.receiptSerialNumber), 1)]), _: 1 }), a.value.status === m(ee).PASS.V ? (u(), f(p, { key: 0, type: "info" }, { default: t(() => [o("出库单：" + s(a.value.outSerialNumber), 1)]), _: 1 })) : y("", true), a.value.boolPartyA ? (u(), f(p, { key: 1, type: "danger" }, { default: t(() => n[1] || (n[1] = [o("甲供")])), _: 1, __: [1] })) : y("", true)]), titleRight: t(() => [e(ae, { params: { id: a.value.id }, fn: m(te), size: "default" }, { default: t(() => n[2] || (n[2] = [o("转换单详情下载")])), _: 1, __: [2] }, 8, ["params", "fn"])]), content: t(() => [e(p, { effect: "plain" }, { default: t(() => n[3] || (n[3] = [o("原物料信息")])), _: 1, __: [3] }), e(V, { column: 3, border: "", style: { margin: "10px 0" } }, { default: t(() => [e(i, { "label-class-name": "contractLabel", label: "物料名称" }, { default: t(() => [o(s(a.value.classifyName || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "物料编号" }, { default: t(() => [o(s(a.value.serialNumber || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "规格" }, { default: t(() => [o(s(a.value.specification || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "厚(mm)*宽(mm)" }, { default: t(() => [o(s(a.value.widthThick || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "品牌" }, { default: t(() => [o(s(a.value.brand || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "颜色" }, { default: t(() => [o(s(a.value.color || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "卷号" }, { default: t(() => [o(s(a.value.heatNoAndBatchNo || "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "项目" }, { default: t(() => [o(s(a.value.project ? m(le)(a.value.project) : "-"), 1)]), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "仓库" }, { default: t(() => {
      var c;
      return [o(s(((c = a.value.warehouse) == null ? void 0 : c.name) || "-"), 1)];
    }), _: 1 }), e(i, { "label-class-name": "contractLabel", label: "备注" }, { default: t(() => [o(s(a.value.remark || "-"), 1)]), _: 1 })]), _: 1 }), e(j, null, { default: t(() => n[4] || (n[4] = [R("span", { class: "title" }, "转换后物料信息", -1)])), _: 1, __: [4] }), q((u(), f(B, { data: a.value.convertDetailDTOList, "data-format": L.value, "show-summary": "", "summary-method": T, "max-height": m(E) - 220 }, { default: t(() => [e(l, { label: "序号", type: "index", align: "center", width: "60" }, { default: t(({ row: { sourceRow: c }, $index: A }) => [c.boolSurplus ? (u(), g("span", ne, "余料")) : (u(), g("span", ie, s(A + 1), 1))]), _: 1 }), e(l, { key: "serialNumber", prop: "serialNumber", label: "物料编号", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "length", prop: "length", label: "长(mm)", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "width", prop: "width", label: "宽(mm)", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "thickness", prop: "thickness", label: "厚(mm)", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "quantity", prop: "quantity", label: "数量（张）", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "mete", prop: "mete", label: "重量（kg）", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "amountExcludingVat", prop: "amountExcludingVat", label: "转换总金额(不含税)", align: "center", "show-overflow-tooltip": "", "min-width": "120" }), e(l, { key: "project", prop: "project", label: "所属项目", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), e(l, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "workshopName", prop: "workshopName", label: "车间", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "warehouse.name", prop: "warehouse.name", label: "仓库", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "recipientName", prop: "recipientName", label: "领用人", align: "center", "show-overflow-tooltip": "" }), e(l, { key: "outboundTime", prop: "outboundTime", label: "出库时间", align: "center", width: "150", "show-overflow-tooltip": "" }), e(l, { key: "boolOutbound", prop: "boolOutbound", label: "是否出库", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[I, w.value]])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, me = $(re, [["__scopeId", "data-v-6913cc44"]]);
export {
  me as default
};
