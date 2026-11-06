import { ref as h } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as m } from "vue";
import { createBlock as d } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as s } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as j } from "vue";
import { createElementBlock as y } from "vue";
import { ElTag as C } from "element-plus";
import { ElDescriptionsItem as R } from "element-plus";
import { ElDescriptions as A } from "element-plus";
import { ElDivider as H } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { vLoading as q } from "element-plus";
import { _ as F, au as I, gt as P, o as z, cO as M, jl as U, kD as K, z as G, ba as J, jN as Q } from "../../../../../../../../../shared/runtime.js";
const W = { key: 0 }, X = { key: 1 }, Y = { __name: "detail", setup(Z) {
  const w = h(), k = h([["project", "parse-project"], ["quantity", ["to-fixed-field", "measurePrecision"]], ["mete", ["to-fixed-field", "accountingPrecision"]], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["boolOutbound", ["parse-enum", I]]]), { CRUD: v, crud: b, detail: o } = P(), { maxHeight: N } = z({ mainBox: ".convert-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, w);
  v.HOOK.beforeDetailLoaded = async (p, l) => {
    l.widthThick = l.thickness || l.width ? (l.thickness || "-") + "*" + (l.width || "-") : "-", await M(l.convertDetailDTOList), l.convertDetailDTOList = await U(l.convertDetailDTOList, { toSmallest: false, toNum: true });
  };
  function D(p) {
    return J(p, { props: ["quantity", ["mete", Q.weight.precision]] });
  }
  return (p, l) => {
    const u = C, c = R, L = A, x = H, n = V, T = _("table-cell-tag"), S = _("common-table"), E = _("common-drawer"), O = q;
    return m(), d(E, { ref_key: "drawerRef", ref: w, visible: a(b).detailVisible, "content-loading": a(b).detailLoading, "before-close": a(b).cancelDetail, title: "详情", "show-close": true, size: "85%", "custom-class": "convert-detail" }, { titleAfter: t(() => [e(u, { type: "success" }, { default: t(() => [r("条板转换单：" + s(a(o).receiptSerialNumber), 1)]), _: 1 }), a(o).status === a(K).PASS.V ? (m(), d(u, { key: 0, type: "info" }, { default: t(() => [r("出库单：" + s(a(o).outSerialNumber), 1)]), _: 1 })) : g("", true), a(o).boolPartyA ? (m(), d(u, { key: 1, type: "danger" }, { default: t(() => l[0] || (l[0] = [r("甲供")])), _: 1, __: [0] })) : g("", true)]), content: t(() => [e(u, { effect: "plain" }, { default: t(() => l[1] || (l[1] = [r("原物料信息")])), _: 1, __: [1] }), e(L, { column: 3, border: "", style: { margin: "10px 0" } }, { default: t(() => [e(c, { "label-class-name": "contractLabel", label: "物料名称" }, { default: t(() => [r(s(a(o).classifyName || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "物料编号" }, { default: t(() => [r(s(a(o).serialNumber || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "规格" }, { default: t(() => [r(s(a(o).specification || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "厚(mm)*宽(mm)" }, { default: t(() => [r(s(a(o).widthThick || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "品牌" }, { default: t(() => [r(s(a(o).brand || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "颜色" }, { default: t(() => [r(s(a(o).color || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "卷号" }, { default: t(() => [r(s(a(o).heatNoAndBatchNo || "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "项目" }, { default: t(() => [r(s(a(o).project ? a(G)(a(o).project) : "-"), 1)]), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "车间" }, { default: t(() => {
      var i;
      return [r(s(((i = a(o).warehouse) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), e(c, { "label-class-name": "contractLabel", label: "备注" }, { default: t(() => [r(s(a(o).remark || "-"), 1)]), _: 1 })]), _: 1 }), e(x, null, { default: t(() => l[2] || (l[2] = [f("span", { class: "title" }, "转换后物料信息", -1)])), _: 1, __: [2] }), j((m(), d(S, { data: a(o).convertDetailDTOList, "data-format": k.value, "show-summary": "", "summary-method": D, "max-height": a(N) - 220 }, { default: t(() => [e(n, { label: "序号", type: "index", align: "center", width: "60" }, { default: t(({ row: { sourceRow: i }, $index: B }) => [i.boolSurplus ? (m(), y("span", W, "余料")) : (m(), y("span", X, s(B + 1), 1))]), _: 1 }), e(n, { key: "serialNumber", prop: "serialNumber", label: "物料编号", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "length", prop: "length", label: "长(mm)", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "width", prop: "width", label: "宽(mm)", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "thickness", prop: "thickness", label: "厚(mm)", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "quantity", prop: "quantity", label: "数量（张）", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "mete", prop: "mete", label: "重量（kg）", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "project", prop: "project", label: "所属项目", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), e(n, { key: "workshopName", prop: "workshopName", label: "车间", align: "center", "show-overflow-tooltip": "" }, { default: t(({ row: { sourceRow: i } }) => [f("span", null, s(i.boolOutbound ? i.workshopName : "-"), 1)]), _: 1 }), e(n, { key: "warehouse.name", prop: "warehouse.name", label: "存储位置", align: "center", "show-overflow-tooltip": "" }, { default: t(({ row: { sourceRow: i } }) => [e(T, { show: !i.boolOutbound && i.workshopName, name: i.workshopName, color: "#e64242", offset: 15 }, null, 8, ["show", "name"]), f("span", null, s(i.warehouse.name), 1)]), _: 1 }), e(n, { key: "recipientName", prop: "recipientName", label: "领用人", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "outboundTime", prop: "outboundTime", label: "出库时间", align: "center", "show-overflow-tooltip": "", width: "150" }), e(n, { key: "boolOutbound", prop: "boolOutbound", label: "是否出库", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[O, p.loading]])]), _: 1 }, 8, ["visible", "content-loading", "before-close"]);
  };
} }, te = F(Y, [["__scopeId", "data-v-edefb2bc"]]);
export {
  te as default
};
