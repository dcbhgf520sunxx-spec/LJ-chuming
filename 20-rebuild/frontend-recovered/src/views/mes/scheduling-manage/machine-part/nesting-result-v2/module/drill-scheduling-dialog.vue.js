import { ref as u } from "vue";
import { reactive as U } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as z } from "vue";
import { createBlock as H } from "vue";
import { withCtx as r } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as v } from "vue";
import { withModifiers as j } from "vue";
import { createElementVNode as k } from "vue";
import { toDisplayString as V } from "vue";
import { unref as w } from "vue";
import { isRef as Y } from "vue";
import { ElNotification as D } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { ElCascader as Q } from "element-plus";
import { ElDatePicker as W } from "element-plus";
import { ElForm as $ } from "element-plus";
import { u as J, qQ as K, cf as L, oT as A, oS as X, qz as Z, rl as ee, rm as le, qR as te, qw as ae } from "../../../../../../shared/runtime.js";
const se = { __name: "drill-scheduling-dialog", props: { visible: { type: Boolean, default: false }, totalList: { type: Array, default: () => [] }, queryParams: { type: Object }, drillData: { type: Object, default: () => {
} }, groupsId: { type: Number }, schedulingId: { Type: Number }, labelInfo: { type: Object, default: () => {
} }, cutSendStatus: { type: [Number, String], default: void 0 } }, emits: ["update:visible", "success"], setup(c, { emit: E }) {
  const g = u(), P = u(), i = c, T = E, { visible: y, handleClose: C } = J({ emit: T, props: i, field: "visible", showHook: S });
  function S() {
    a.drillGroupsId = void 0, a.drillAskCompleteTime = i.labelInfo.artifactAskCompleteTime, M();
  }
  function q(s) {
    var e;
    return s > ((e = i.labelInfo) == null ? void 0 : e.artifactAskCompleteTime);
  }
  const _ = u([]), p = u(false), a = U({ drillGroupsId: void 0, drillAskCompleteTime: void 0, drillCutConfigId: void 0 }), N = { drillGroupsId: [{ required: true, message: "请选择钻孔生产班组", trigger: "change" }], drillAskCompleteTime: [{ required: true, message: "请选择钻孔日期", trigger: "change" }], drillCutConfigId: [{ required: true, message: "请选择钻孔方式", trigger: "change" }] };
  function O() {
    D({ title: "本次套料作废", type: "info", duration: 2500 }), C();
  }
  const h = u(false), b = u([]);
  async function M() {
    var s;
    if (!h.value) {
      b.value = [];
      try {
        const e = await K({ processType: L.DRILL_HOLE.V, partProdMode: A.SEMI_AUTOMATIC.V, partType: X.SHEET_PART.V });
        b.value = ((s = e.mesBuildingPartCutConfigWorkShopDTOList) == null ? void 0 : s.map((t) => {
          var l;
          return t.name = t.workshopName, t.children = ((l = t.mesBuildingPartCutConfigLineDTOList) == null ? void 0 : l.map((n) => {
            var f;
            return n.name = n.productionLineName, n.children = ((f = n.mesBuildingPartCutConfigTeamDTOList) == null ? void 0 : f.map((m) => (m.name = m.teamName, m))) || [], n;
          })) || [], t;
        })) || [], h.value = true;
      } catch (e) {
        console.log("获取生产组的信息失败", e);
      }
    }
  }
  async function R() {
    var e, t;
    let s = false;
    await g.value.validate((l) => {
      s = l;
    }), p.value = true;
    try {
      if (s) {
        const l = { drillAskCompleteTime: a.drillAskCompleteTime, drillGroupsId: a.drillGroupsId, drillCutConfigId: a.drillCutConfigId, workshop: i.labelInfo.workshopId, nestingResultIdList: (e = i.queryParams.data) == null ? void 0 : e.map((n) => n.id), productionLineId: i.queryParams.productionLineId, machinePartCuttingConfigId: (t = i.queryParams.data[0]) == null ? void 0 : t.machineToolId, jobId: i.labelInfo.jobId, finishDate: i.queryParams.finishDate };
        i.cutSendStatus === Z.HAS_ISSUED.V ? await ee(l) : await le(l), D({ title: "零件下发保存成功", type: "success", duration: 2500 }), C(), T("success");
      }
    } catch (l) {
      console.log("零件下发保存失败", l);
    } finally {
      p.value = false;
    }
  }
  async function G(s) {
    const e = await te({ partProdMode: A.SEMI_AUTOMATIC.V, partType: ae.BOARD.V, processType: L.DRILL_HOLE.V, teamId: s });
    _.value = e.map((t) => ({ name: t.deviceTypeName, id: t.id }));
  }
  return (s, e) => {
    const t = I("common-button"), l = F, n = Q, f = I("common-select"), m = W, B = $, x = I("common-dialog");
    return z(), H(x, { ref_key: "dialogRef", ref: P, title: "钻孔排产", "show-close": false, visible: w(y), "onUpdate:visible": e[4] || (e[4] = (d) => Y(y) ? y.value = d : null), "before-close": w(C), closeOnClickModal: false, width: "400px" }, { titleRight: r(() => [o(t, { type: "primary", size: "default", onClick: e[0] || (e[0] = (d) => R(g.value)), loading: p.value }, { default: r(() => e[5] || (e[5] = [v(" 确定 ")])), _: 1, __: [5] }, 8, ["loading"]), o(t, { size: "default", onClick: j(O, ["stop"]), loading: p.value }, { default: r(() => e[6] || (e[6] = [v(" 关闭 ")])), _: 1, __: [6] }, 8, ["loading"])]), default: r(() => [o(B, { ref_key: "formRef", ref: g, model: a, rules: N, size: "default", "label-width": "120px", class: "demo-form" }, { default: r(() => [o(l, { label: "零件数:", prop: "quantity" }, { default: r(() => [k("span", null, V(c.drillData.quantity), 1)]), _: 1 }), o(l, { label: "钻孔数:", prop: "drillQuantity" }, { default: r(() => [k("span", null, V(c.drillData.drillQuantity), 1)]), _: 1 }), o(l, { label: "钻孔班组:", prop: "drillGroupsId" }, { default: r(() => [o(n, { modelValue: a.drillGroupsId, "onUpdate:modelValue": e[1] || (e[1] = (d) => a.drillGroupsId = d), options: b.value, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, style: { width: "100%" }, filterable: "", clearable: "", placeholder: "请选择钻孔班组", onChange: G }, null, 8, ["modelValue", "options"])]), _: 1 }), o(l, { label: "钻孔方式", prop: "drillCutConfigId" }, { default: r(() => [o(f, { modelValue: a.drillCutConfigId, "onUpdate:modelValue": e[2] || (e[2] = (d) => a.drillCutConfigId = d), options: _.value, dataStructure: { key: "id", label: "name", value: "id" }, type: "other", size: "default", clearable: "", placeholder: "钻孔方式", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 }), o(l, { label: "钻孔日期:", prop: "drillAskCompleteTime" }, { default: r(() => [o(m, { modelValue: a.drillAskCompleteTime, "onUpdate:modelValue": e[3] || (e[3] = (d) => a.drillAskCompleteTime = d), type: "date", size: "default", class: "date-item filter-item", style: { width: "100% !important" }, placeholder: "选择钻孔日期", clearable: false, format: "YYYY-MM-DD", "value-format": "x", "disabled-date": q }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  se as default
};
