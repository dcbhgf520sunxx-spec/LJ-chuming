import { ref as B } from "vue";
import { inject as v } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as d } from "vue";
import { createBlock as h } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as P } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as s } from "vue";
import { createElementBlock as V } from "vue";
import { isRef as M } from "vue";
import { ElMessage as A } from "element-plus";
import { ElPopconfirm as T } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { o as L } from "../../../../../modules/mes-ship-receipt-ae6ae43f.js";
import { u as O, xY as k, pA as Q, i as D, qS as q, z, b as F, jl as H, cS as J } from "../../../../../shared/runtime.js";
const $ = { key: 0 }, Y = { key: 1 }, Z = { __name: "submit-review", props: { modelValue: { type: Boolean, require: true }, submitData: { type: Array, default: () => [] }, maxHeight: { type: Number, default: 100 } }, emits: ["success", "update:modelValue"], setup(c, { emit: j }) {
  const w = j, y = c, g = B(false), { visible: p, handleClose: x } = O({ emit: w, props: y }), C = v("globalProjectId"), I = v("globalProject");
  async function E() {
    if (F(y.submitData)) {
      A.success("发运冻结明细不能为空");
      return;
    }
    try {
      g.value = true;
      const m = JSON.parse(JSON.stringify(y.submitData));
      await H(m, { toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["theoryTotalWeight", "weighingWeight", "outboundMete"] });
      const u = [];
      m.forEach((l) => {
        u.push({ detailId: l.uid, detailName: l.partName, materialId: l.materialId, projectId: l.projectId, mesWorkshopId: l.mesWorkshopId, recipientId: l.recipientId, quantity: l.outboundUnitType === J.MEASURE.V ? l.outboundQuantity : l.outboundMete, outboundAddress: l.outboundAddress, remark: l.remark });
      });
      const b = { projectId: C.value, wmsShipmentReceiveApproveDetailDTOParamList: u };
      await L(b), A.success("提交成功"), w("success"), x();
    } catch (m) {
      console.log("出库办理", m);
    } finally {
      g.value = false;
    }
  }
  function S(m, u) {
    w("deleteSubmitData", m, u);
  }
  return (m, u) => {
    const b = f("common-button"), l = T, N = f("table-cell-tag"), a = R, W = f("common-table"), U = f("common-drawer");
    return d(), h(U, { ref: "drawerRef", modelValue: n(p), "onUpdate:modelValue": u[0] || (u[0] = (e) => M(p) ? p.value = e : null), "before-close": n(x), title: "本次办理明细", "show-close": true, "close-on-click-modal": false, size: "95%", "custom-class": "raw-mat-application-review-form" }, { titleRight: o(() => [t(l, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定提交吗?", onConfirm: E }, { reference: o(() => {
      var e;
      return [t(b, { loading: g.value, size: "default", type: "success", disabled: ((e = c.submitData) == null ? void 0 : e.length) === 0 }, { default: o(() => u[1] || (u[1] = [P("提交")])), _: 1, __: [1] }, 8, ["loading", "disabled"])];
    }), _: 1 })]), content: o(() => [n(p) ? (d(), h(W, { key: 0, data: c.submitData, "max-height": c.maxHeight - 50, "row-key": "id", "show-empty-symbol": false, "return-source-data": "" }, { default: o(() => [t(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: o(({ row: e, $index: i }) => [e.boolPartyA ? (d(), h(N, { key: 0, show: !!e.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : _("", true), !e.boolPartyA && e.materialIsWhole === n(k).ODDMENT.V ? (d(), h(N, { key: 1, color: n(k).V[e.materialIsWhole].COLOR, name: n(k).VL[e.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : _("", true), r("span", null, s(i + 1), 1)]), _: 1 }), t(a, { key: "partName", prop: "partName", label: "配套件名称", align: "left", "show-overflow-tooltip": "", "min-width": "120px" }), t(a, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "", "min-width": "100" }), t(a, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", "min-width": "100" }), t(a, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "130px" }, { default: o(({ row: e }) => [r("span", null, s(n(Q)(e)), 1)]), _: 1 }), t(a, { key: "brand", align: "left", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "100" }, { default: o(({ row: e }) => [r("span", null, s(e.brand || "-"), 1)]), _: 1 }), t(a, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", "show-overflow-tooltip": "", width: "80px" }, { default: o(({ row: e }) => [r("span", null, s(e.measureUnit || "-"), 1)]), _: 1 }), t(a, { key: "outboundQuantity", prop: "outboundQuantity", label: "出库数量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: o(({ row: e }) => [e.measureUnit ? (d(), V("span", $, s(e.outboundQuantity || "-"), 1)) : (d(), V("span", Y, "-"))]), _: 1 }), t(a, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", "show-overflow-tooltip": "", width: "80px" }, { default: o(({ row: e }) => [r("span", null, s(e.accountingUnit || "-"), 1)]), _: 1 }), t(a, { key: "outboundMete", prop: "outboundMete", label: "出库核算量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: o(({ row: e }) => [r("span", null, s(e.outboundMete || "-"), 1)]), _: 1 }), t(a, { key: "warehouse.name", prop: "warehouse.name", label: "所属仓库", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: o(({ row: e }) => {
      var i;
      return [r("span", null, s(((i = e.warehouse) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), t(a, { key: "outboundAddress", prop: "outboundAddress", label: "目的地", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: o(({ row: e }) => [r("span", null, s(n(D)(e.outboundAddress) ? n(q).VL[e.outboundAddress] : "-"), 1)]), _: 1 }), t(a, { key: "project.name", prop: "project.name", label: "领用项目", align: "center", "show-overflow-tooltip": "", "min-width": "150px" }, { default: o(() => [r("span", null, s(n(D)(n(I)) ? n(z)(n(I)) : "-"), 1)]), _: 1 }), t(a, { key: "mesWorkshop.name", prop: "mesWorkshop.name", label: "领用车间", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: o(({ row: e }) => {
      var i;
      return [r("span", null, s(((i = e.mesWorkshop) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), t(a, { key: "userInfo.label", prop: "userInfo.label", label: "领用人", align: "center", "show-overflow-tooltip": "", width: "90px" }, { default: o(({ row: e }) => {
      var i;
      return [r("span", null, s(((i = e.userInfo) == null ? void 0 : i.label) || "-"), 1)];
    }), _: 1 }), t(a, { align: "center", fixed: "right", label: "操作", width: "80px" }, { default: o((e) => [t(l, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (i) => S(e.row, e.$index) }, { reference: o(() => [t(b, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])) : _("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Z as default
};
