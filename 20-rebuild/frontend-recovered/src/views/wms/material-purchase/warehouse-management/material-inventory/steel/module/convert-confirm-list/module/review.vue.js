import { ref as u } from "vue";
import { watch as P } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as m } from "vue";
import { createBlock as k } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as U } from "vue";
import { unref as b } from "vue";
import { createElementVNode as N } from "vue";
import { withDirectives as M } from "vue";
import { createElementBlock as x } from "vue";
import { isRef as $ } from "vue";
import { ElMessage as D } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElDescriptionsItem as J } from "element-plus";
import { ElDescriptions as K } from "element-plus";
import { ElDivider as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { _ as Y, u as Z, au as ee, o as ae, z8 as te, cO as le, jl as oe, z as se, ba as ne, jN as re, z9 as ie, za as ce } from "../../../../../../../../../shared/runtime.js";
import { _ as ue } from "../../../../../../../../../modules/review-confirm-button-aa3600ad.js";
const de = { key: 0 }, me = { key: 1 }, pe = { __name: "review", props: { detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue", "refresh"], setup(T, { emit: j }) {
  const _ = j, d = T, { visible: v, handleClose: w } = Z({ emit: _, props: d }), h = u(false), a = u({}), p = u(false), f = u(false), L = u(), E = u([["project", "parse-project"], ["quantity", ["to-fixed-field", "measurePrecision"]], ["mete", ["to-fixed-field", "accountingPrecision"]], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["boolOutbound", ["parse-enum", ee]]]), { maxHeight: O } = ae({ mainBox: ".convert-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, L);
  function B(i) {
    return ne(i, { props: ["quantity", ["mete", re.weight.precision]] });
  }
  P(() => d.detailInfo, (i) => {
    i.id && I();
  }, { deep: true, immediate: true });
  async function I() {
    a.value = {}, h.value = true;
    try {
      const i = await te(d.detailInfo.id);
      a.value = i || {}, a.value.widthThick = a.value.thickness || a.value.width ? (a.value.thickness || "-") + "*" + (a.value.width || "-") : "-", await le(a.value.convertDetailDTOList), a.value.convertDetailDTOList = await oe(a.value.convertDetailDTOList, { toSmallest: false, toNum: true });
    } catch (i) {
      console.log(i);
    } finally {
      h.value = false;
    }
  }
  async function R() {
    try {
      p.value = true, await ie(d.detailInfo.id), D.success("通过成功"), _("refresh"), w();
    } catch (i) {
      console.log("通过提交", i);
    } finally {
      p.value = false;
    }
  }
  async function S() {
    try {
      f.value = true, await ce(d.detailInfo.id), D.success("退回成功"), _("refresh"), w();
    } catch (i) {
      console.log("退回", i);
    } finally {
      f.value = false;
    }
  }
  return (i, n) => {
    const g = G, c = J, V = K, C = Q, o = W, q = y("table-cell-tag"), z = y("common-table"), A = y("common-drawer"), F = X;
    return m(), k(A, { ref_key: "detailRef", ref: L, "append-to-body": "", "close-on-click-modal": false, "before-close": b(w), modelValue: b(v), "onUpdate:modelValue": n[2] || (n[2] = (l) => $(v) ? v.value = l : null), title: "审核", "wrapper-closable": false, size: "85%", "custom-class": "convert-detail" }, { titleAfter: t(() => [e(g, { type: "success" }, { default: t(() => [r("条板转换单：" + s(a.value.receiptSerialNumber), 1)]), _: 1 }), a.value.boolPartyA ? (m(), k(g, { key: 0, type: "danger" }, { default: t(() => n[3] || (n[3] = [r("甲供")])), _: 1, __: [3] })) : U("", true)]), titleRight: t(() => [e(ue, { "passed-loading": p.value, "onUpdate:passedLoading": n[0] || (n[0] = (l) => p.value = l), "returned-loading": f.value, "onUpdate:returnedLoading": n[1] || (n[1] = (l) => f.value = l), "passed-fn": R, "returned-fn": S }, null, 8, ["passed-loading", "returned-loading"])]), content: t(() => [e(g, { effect: "plain" }, { default: t(() => n[4] || (n[4] = [r("原物料信息")])), _: 1, __: [4] }), e(V, { column: 3, border: "", style: { margin: "10px 0" } }, { default: t(() => [e(c, { "label-class-name": "contractLabel", label: "物料名称" }, { default: t(() => [r(s(a.value.classifyName || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "物料编号" }, { default: t(() => [r(s(a.value.serialNumber || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "规格" }, { default: t(() => [r(s(a.value.specification || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "厚(mm)*宽(mm)" }, { default: t(() => [r(s(a.value.widthThick || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "品牌" }, { default: t(() => [r(s(a.value.brand || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "颜色" }, { default: t(() => [r(s(a.value.color || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "卷号" }, { default: t(() => [r(s(a.value.heatNoAndBatchNo || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "项目" }, { default: t(() => [r(s(a.value.project ? b(se)(a.value.project) : "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "车间" }, { default: t(() => {
      var l;
      return [r(s(((l = a.value.warehouse) == null ? void 0 : l.name) || "-"), 1)];
    }), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "备注" }, { default: t(() => [r(s(a.value.remark || "-"), 1)]), _: 1 })]), _: 1 }), e(C, null, { default: t(() => n[5] || (n[5] = [N("span", { class: "title" }, "转换后物料信息", -1)])), _: 1, __: [5] }), M((m(), k(z, { data: a.value.convertDetailDTOList, "data-format": E.value, "show-summary": "", "summary-method": B, "max-height": b(O) - 220 }, { default: t(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }, { default: t(({ row: { sourceRow: l }, $index: H }) => [l.boolSurplus ? (m(), x("span", de, "余料")) : (m(), x("span", me, s(H + 1), 1))]), _: 1 }), e(o, { key: "serialNumber", prop: "serialNumber", label: "物料编号", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "length", prop: "length", label: "长(mm)", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "width", prop: "width", label: "宽(mm)", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "thickness", prop: "thickness", label: "厚(mm)", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "quantity", prop: "quantity", label: "数量（张）", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "mete", prop: "mete", label: "重量（kg）", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "project", prop: "project", label: "所属项目", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), e(o, { key: "workshopName", prop: "workshopName", label: "车间", align: "center", "show-overflow-tooltip": "" }, { default: t(({ row: { sourceRow: l } }) => [N("span", null, s(l.boolOutbound ? l.workshopName : "-"), 1)]), _: 1 }), e(o, { key: "warehouse.name", prop: "warehouse.name", label: "存储位置", align: "center", "show-overflow-tooltip": "" }, { default: t(({ row: { sourceRow: l } }) => [e(q, { show: !l.boolOutbound && l.workshopName, name: l.workshopName, color: "#e64242", offset: 15 }, null, 8, ["show", "name"]), N("span", null, s(l.warehouse.name), 1)]), _: 1 }), e(o, { key: "recipientName", prop: "recipientName", label: "领用人", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "outboundTime", prop: "outboundTime", label: "出库时间", align: "center", "show-overflow-tooltip": "", width: "150" }), e(o, { key: "boolOutbound", prop: "boolOutbound", label: "是否出库", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[F, h.value]])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, ve = Y(pe, [["__scopeId", "data-v-1c6a85ca"]]);
export {
  ve as default
};
