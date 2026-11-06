import { ref as u } from "vue";
import { reactive as U } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as z } from "vue";
import { createBlock as H } from "vue";
import { withCtx as i } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as v } from "vue";
import { withModifiers as j } from "vue";
import { createElementVNode as k } from "vue";
import { toDisplayString as L } from "vue";
import { unref as V } from "vue";
import { isRef as Y } from "vue";
import { ElNotification as w } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { ElCascader as Q } from "element-plus";
import { ElDatePicker as W } from "element-plus";
import { ElForm as J } from "element-plus";
import { u as $, qQ as K, cf as D, oT as P, oS as X, rm as Z, qR as ee, qw as le } from "../../../../../../shared/runtime.js";
const oe = { __name: "drill-scheduling-dialog", props: { visible: { type: Boolean, default: false }, totalList: { type: Array, default: () => [] }, queryParams: { type: Object }, drillData: { type: Object, default: () => {
} }, groupsId: { type: Number }, schedulingId: { Type: Number }, labelInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(f, { emit: A }) {
  const g = u(), E = u(), r = f, T = A, { visible: y, handleClose: C } = $({ emit: T, props: r, field: "visible", showHook: q });
  function q() {
    a.drillGroupsId = void 0, a.drillAskCompleteTime = r.labelInfo.artifactAskCompleteTime, R();
  }
  function O(o) {
    var e;
    return o > ((e = r.labelInfo) == null ? void 0 : e.artifactAskCompleteTime);
  }
  const h = u([]), p = u(false), a = U({ drillGroupsId: void 0, drillAskCompleteTime: void 0, drillCutConfigId: void 0 }), M = { drillGroupsId: [{ required: true, message: "请选择钻孔生产班组", trigger: "change" }], drillAskCompleteTime: [{ required: true, message: "请选择钻孔日期", trigger: "change" }], drillCutConfigId: [{ required: true, message: "请选择钻孔方式", trigger: "change" }] };
  function N() {
    w({ title: "本次套料作废", type: "info", duration: 2500 }), C();
  }
  const _ = u(false), b = u([]);
  async function R() {
    var o;
    if (!_.value) {
      b.value = [];
      try {
        const e = await K({ processType: D.DRILL_HOLE.V, partProdMode: P.SEMI_AUTOMATIC.V, partType: X.SHEET_PART.V });
        b.value = ((o = e.mesBuildingPartCutConfigWorkShopDTOList) == null ? void 0 : o.map((l) => {
          var s;
          return l.name = l.workshopName, l.children = ((s = l.mesBuildingPartCutConfigLineDTOList) == null ? void 0 : s.map((d) => {
            var c;
            return d.name = d.productionLineName, d.children = ((c = d.mesBuildingPartCutConfigTeamDTOList) == null ? void 0 : c.map((m) => (m.name = m.teamName, m))) || [], d;
          })) || [], l;
        })) || [], _.value = true;
      } catch (e) {
        console.log("获取生产组的信息失败", e);
      }
    }
  }
  async function G() {
    var e;
    let o = false;
    await g.value.validate((l) => {
      o = l;
    }), p.value = true;
    try {
      if (o) {
        const l = { drillAskCompleteTime: a.drillAskCompleteTime, drillGroupsId: a.drillGroupsId, drillCutConfigId: a.drillCutConfigId, workshop: r.labelInfo.workshopId, machinePartNestingCutJobParamList: r.queryParams.data, productionLineId: r.queryParams.productionLineId, machineTool: (e = r.queryParams.data[0]) == null ? void 0 : e.machineToolId, jobId: r.labelInfo.jobId, finishDate: r.queryParams.finishDate };
        await Z(l), w({ title: "零件下发保存成功", type: "success", duration: 2500 }), C(), T("success");
      }
    } catch (l) {
      console.log("零件下发保存失败", l);
    } finally {
      p.value = false;
    }
  }
  async function B(o) {
    const e = await ee({ partProdMode: P.SEMI_AUTOMATIC.V, partType: le.BOARD.V, processType: D.DRILL_HOLE.V, teamId: o });
    h.value = e.map((l) => ({ name: l.deviceTypeName, id: l.id }));
  }
  return (o, e) => {
    const l = I("common-button"), s = F, d = Q, c = I("common-select"), m = W, x = J, S = I("common-dialog");
    return z(), H(S, { ref_key: "dialogRef", ref: E, title: "钻孔排产", "show-close": false, visible: V(y), "onUpdate:visible": e[4] || (e[4] = (n) => Y(y) ? y.value = n : null), "before-close": V(C), closeOnClickModal: false, width: "400px" }, { titleRight: i(() => [t(l, { type: "primary", size: "default", onClick: e[0] || (e[0] = (n) => G(g.value)), loading: p.value }, { default: i(() => e[5] || (e[5] = [v(" 确定 ")])), _: 1, __: [5] }, 8, ["loading"]), t(l, { size: "default", onClick: j(N, ["stop"]), loading: p.value }, { default: i(() => e[6] || (e[6] = [v(" 关闭 ")])), _: 1, __: [6] }, 8, ["loading"])]), default: i(() => [t(x, { ref_key: "formRef", ref: g, model: a, rules: M, size: "default", "label-width": "120px", class: "demo-form" }, { default: i(() => [t(s, { label: "零件数:", prop: "quantity" }, { default: i(() => [k("span", null, L(f.drillData.quantity), 1)]), _: 1 }), t(s, { label: "钻孔数:", prop: "drillQuantity" }, { default: i(() => [k("span", null, L(f.drillData.drillQuantity), 1)]), _: 1 }), t(s, { label: "钻孔班组:", prop: "drillGroupsId" }, { default: i(() => [t(d, { modelValue: a.drillGroupsId, "onUpdate:modelValue": e[1] || (e[1] = (n) => a.drillGroupsId = n), options: b.value, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, style: { width: "100%" }, filterable: "", clearable: "", placeholder: "请选择钻孔班组", onChange: B }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "钻孔方式", prop: "drillCutConfigId" }, { default: i(() => [t(c, { modelValue: a.drillCutConfigId, "onUpdate:modelValue": e[2] || (e[2] = (n) => a.drillCutConfigId = n), options: h.value, dataStructure: { key: "id", label: "name", value: "id" }, type: "other", size: "default", clearable: "", placeholder: "钻孔方式", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "钻孔日期:", prop: "drillAskCompleteTime" }, { default: i(() => [t(m, { modelValue: a.drillAskCompleteTime, "onUpdate:modelValue": e[3] || (e[3] = (n) => a.drillAskCompleteTime = n), type: "date", size: "default", class: "date-item filter-item", style: { width: "100% !important" }, placeholder: "选择钻孔日期", clearable: false, format: "YYYY-MM-DD", "value-format": "x", "disabled-date": O }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  oe as default
};
