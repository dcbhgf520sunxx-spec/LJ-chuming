import { ref as m } from "vue";
import { reactive as U } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as z } from "vue";
import { createBlock as j } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { withModifiers as h } from "vue";
import { createTextVNode as v } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as k } from "vue";
import { unref as L } from "vue";
import { isRef as H } from "vue";
import { ElNotification as D } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElCascader as F } from "element-plus";
import { ElDatePicker as Q } from "element-plus";
import { ElForm as W } from "element-plus";
import { u as $, qQ as J, cf as w, oT as E, oS as K, qU as X, qV as Z, qR as ee, qw as le } from "../../../../../shared/runtime.js";
const oe = { __name: "drill-scheduling-dialog", props: { visible: { type: Boolean, default: false }, totalList: { type: Array, default: () => [] }, queryParams: { type: Object }, drillData: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(c, { emit: q }) {
  const f = m(), A = m(), d = c, _ = q, { visible: g, handleClose: y } = $({ emit: _, props: d, field: "visible", showHook: O }), I = m([]), C = m(false), b = m([]);
  function O() {
    t.drillGroupsId = void 0, t.drillAskCompleteTime = d.queryParams.askCompleteTime, N();
  }
  function P(o) {
    return o > d.queryParams.askCompleteTime;
  }
  const t = U({ drillGroupsId: void 0, drillAskCompleteTime: void 0, drillCutConfigId: void 0 }), M = { drillGroupsId: [{ required: true, message: "请选择钻孔生产班组", trigger: "change" }], drillAskCompleteTime: [{ required: true, message: "请选择钻孔日期", trigger: "change" }], drillCutConfigId: [{ required: true, message: "请选择钻孔方式", trigger: "change" }] };
  function R() {
    D({ title: "本次套料作废", type: "info", duration: 2500 }), y();
  }
  async function G() {
    let o = false;
    await f.value.validate((e) => {
      o = e;
    });
    try {
      if (o) {
        const e = [];
        d.totalList.forEach((l) => {
          e.push({ productId: l.productId, quantity: l.quantity, id: l.id, needSchedulingMonth: l.date, projectId: l.project.id, orderId: l.orderId });
        }), await X({ ...d.queryParams, linkList: e, projectId: d.totalList[0].project.id, boolOffLine: Z.NORMAL.V, drillGroupsId: t.drillGroupsId, drillCutConfigId: t.drillCutConfigId, drillAskCompleteTime: t.drillAskCompleteTime, batchOutboundDTOParam: d.drillData.outBoundParams }), D({ title: "钻孔排产保存成功", type: "success", duration: 2500 }), y(), _("success");
      }
    } catch (e) {
      console.log("无需套料排产失败", e);
    } finally {
      C.value = false;
    }
  }
  async function B(o) {
    const e = await ee({ partProdMode: E.SEMI_AUTOMATIC.V, partType: le.BOARD.V, processType: w.DRILL_HOLE.V, teamId: o });
    I.value = e.map((l) => ({ name: l.deviceTypeName, id: l.id }));
  }
  async function N() {
    var o;
    b.value = [];
    try {
      const e = await J({ processType: w.DRILL_HOLE.V, partProdMode: E.SEMI_AUTOMATIC.V, partType: K.SHEET_PART.V });
      b.value = ((o = e.mesBuildingPartCutConfigWorkShopDTOList) == null ? void 0 : o.map((l) => {
        var s;
        return l.name = l.workshopName, l.children = ((s = l.mesBuildingPartCutConfigLineDTOList) == null ? void 0 : s.map((n) => {
          var p;
          return n.name = n.productionLineName, n.children = ((p = n.mesBuildingPartCutConfigTeamDTOList) == null ? void 0 : p.map((u) => (u.name = u.teamName, u))) || [], n;
        })) || [], l;
      })) || [];
    } catch (e) {
      console.log("获取生产组的信息失败", e);
    }
  }
  return (o, e) => {
    const l = T("common-button"), s = Y, n = F, p = T("common-select"), u = Q, S = W, x = T("common-dialog");
    return z(), j(x, { ref_key: "dialogRef", ref: A, title: "钻孔排产", visible: L(g), "onUpdate:visible": e[4] || (e[4] = (r) => H(g) ? g.value = r : null), "show-close": false, "before-close": L(y), closeOnClickModal: false, width: "400px" }, { titleRight: i(() => [a(l, { type: "primary", size: "default", onClick: e[0] || (e[0] = h((r) => G(f.value), ["stop"])), loading: C.value }, { default: i(() => e[5] || (e[5] = [v(" 确定 ")])), _: 1, __: [5] }, 8, ["loading"]), a(l, { size: "default", onClick: h(R, ["stop"]), loading: C.value }, { default: i(() => e[6] || (e[6] = [v(" 关闭 ")])), _: 1, __: [6] }, 8, ["loading"])]), default: i(() => [a(S, { ref_key: "formRef", ref: f, model: t, rules: M, size: "default", "label-width": "120px", class: "demo-form" }, { default: i(() => [a(s, { label: "零件数:", prop: "quantity" }, { default: i(() => [V("span", null, k(c.drillData.data.quantity), 1)]), _: 1 }), a(s, { label: "钻孔数:", prop: "drillQuantity" }, { default: i(() => [V("span", null, k(c.drillData.data.drillQuantity), 1)]), _: 1 }), a(s, { label: "钻孔班组:", prop: "drillGroupsId" }, { default: i(() => [a(n, { modelValue: t.drillGroupsId, "onUpdate:modelValue": e[1] || (e[1] = (r) => t.drillGroupsId = r), options: b.value, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, style: { width: "100%" }, filterable: "", clearable: "", placeholder: "请选择钻孔班组", onChange: B }, null, 8, ["modelValue", "options"])]), _: 1 }), a(s, { label: "钻孔方式", prop: "drillCutConfigId" }, { default: i(() => [a(p, { modelValue: t.drillCutConfigId, "onUpdate:modelValue": e[2] || (e[2] = (r) => t.drillCutConfigId = r), options: I.value, dataStructure: { key: "id", label: "name", value: "id" }, type: "other", size: "default", clearable: "", placeholder: "钻孔方式", disabled: !t.drillGroupsId, style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), a(s, { label: "钻孔日期:", prop: "drillAskCompleteTime" }, { default: i(() => [a(u, { modelValue: t.drillAskCompleteTime, "onUpdate:modelValue": e[3] || (e[3] = (r) => t.drillAskCompleteTime = r), type: "date", size: "default", class: "date-item filter-item", style: { width: "100% !important" }, placeholder: "选择排产日期", clearable: false, format: "YYYY-MM-DD", "value-format": "x", "disabled-date": P }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  oe as default
};
