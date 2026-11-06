import { ref as f } from "vue";
import { watch as Ue } from "vue";
import { resolveComponent as J } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as V } from "vue";
import { withCtx as m } from "vue";
import { createVNode as d } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as M } from "vue";
import { unref as p } from "vue";
import { createCommentVNode as A } from "vue";
import { createElementVNode as G } from "vue";
import { withKeys as te } from "vue";
import { withModifiers as ie } from "vue";
import { withDirectives as He } from "vue";
import { isRef as je } from "vue";
import { ElNotification as ze } from "element-plus";
import { ElTag as Qe } from "element-plus";
import { ElInput as Ge } from "element-plus";
import { ElCheckbox as Ke } from "element-plus";
import { ElTableColumn as Fe } from "element-plus";
import { ElCascader as We } from "element-plus";
import { vLoading as $e } from "element-plus";
import { d as Je, a as Xe, b as Ye } from "../../../../../../modules/process-assistance-e91c5400.js";
import { _ as Ze, n as et, u as tt, o as at, rL as y, aI as Ie, aw as lt, V as Te } from "../../../../../../shared/runtime.js";
import { m as F } from "../../../../../../modules/use-scheduling-line-f234c58c.js";
import ot from "./assistance-preview.vue.js";
import nt from "./assistance-detail-form.vue.js";
import st from "./next-process-assist-dialog.vue.js";
import it from "./assistance-assemble.vue.js";
import "../../../../../../modules/artifact-f1b0ca44.js";
const ut = { class: "head-container" }, rt = { __name: "assistance-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, currentInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(P, { emit: we }) {
  const ue = { CAN_ASSIST: { L: "可协同", K: "可协同", V: 1 }, ASSISTED: { L: "已协同", K: "已协同", V: 2 } };
  et(ue);
  const re = f(), ae = f(false), X = f(false), W = f([]), le = f(false), $ = f({}), Y = f([]), Ee = f(), oe = we, n = P, { visible: ne, handleClose: de } = tt({ emit: oe, props: n, field: "visible", showHook: Ve }), { maxHeight: ce } = at({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, re), ke = f([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), E = f({}), K = f([]), Z = f(false), C = f({}), ee = f([]), _e = f([]), me = f(false), se = f([]), pe = f(false), O = f(false);
  function Ve() {
    le.value = false, W.value = [], fe();
  }
  function fe() {
    E.value = {}, x();
  }
  function Ce(t) {
    ee.value = t;
  }
  Ue([() => {
    var t;
    return (t = $.value) == null ? void 0 : t.id;
  }, () => {
    var t;
    return (t = Y.value) == null ? void 0 : t.length;
  }], ([t, o]) => {
    var b, c, g, h;
    x(), o ? (se.value = [(c = (b = n.info) == null ? void 0 : b.productionLineId) == null ? void 0 : c.id], Y.value.forEach((N) => {
      var u;
      se.value.push((u = N.productionLineId) == null ? void 0 : u.id);
    })) : se.value = [(h = (g = n.info) == null ? void 0 : g.productionLineId) == null ? void 0 : h.id];
  });
  function Ae(t) {
    ee.value = t;
  }
  const Me = (t, o) => !!t, xe = /* @__PURE__ */ new Map([["productionLineId", "同上"]]), Se = { productionLineId: [{ validator: Me, required: true, message: "选择生产组", trigger: "change" }] }, { tableValidate: Le, cleanUpData: Ne, wrongCellMask: ye } = lt({ rules: Se, ditto: xe });
  function Re(t, o, b) {
    b !== 0 && !t && (o.productionLineId = "同上");
  }
  function Pe(t) {
    return t.boolOperations;
  }
  function De(t) {
    t ? ve() : be();
  }
  function x() {
    var t;
    O.value && ((t = n.info) == null ? void 0 : t.taskTypeEnum) === y.ASSEMBLE.V ? ve() : be();
  }
  async function be() {
    var t, o, b, c, g, h, N, u, U, H, j, z, Q, D, q, v, I, T, s;
    try {
      Z.value = true, K.value = [], C.value = {};
      const { content: k } = await Je({ taskOrderId: (t = n.info) == null ? void 0 : t.taskOrderId, taskTypeEnum: ((o = n.info) == null ? void 0 : o.taskTypeEnum) & y.ASSEMBLE.V ? ((b = n.info) == null ? void 0 : b.taskTypeEnum) | y.PARENT_PART.V : (c = n.info) == null ? void 0 : c.taskTypeEnum, processId: (g = n.info) == null ? void 0 : g.process.id, ...E.value });
      for (let S = 0; S < k.length; S++) {
        const e = k[S];
        if (e.assistQuantity = (h = e.totalCanAssistMete) == null ? void 0 : h.quantity, S > 0 && (e.productionLineId = "同上"), e.attributeType = e.taskTypeEnum === y.ASSEMBLE.V ? "部件" : "套料", e.areaName = (N = e.area) == null ? void 0 : N.name, e.monomerName = (u = e.monomer) == null ? void 0 : u.name, e.configId = (U = e.config) == null ? void 0 : U.id, e.numberArr = (H = e.numberList) == null ? void 0 : H.map((i) => ({ id: i, label: i })), e.numbersMap = (j = e == null ? void 0 : e.numbers) == null ? void 0 : j.map((i) => ({ id: i.number, label: i.number, boolReplace: i.boolReplace })), e.isComplete = !!((z = e.totalCompleteMete) != null && z.quantity && ((Q = e.totalTaskMete) != null && Q.quantity) && ((D = e.totalCompleteMete) == null ? void 0 : D.quantity) === ((q = e.totalTaskMete) == null ? void 0 : q.quantity)), (v = e == null ? void 0 : e.mesBuildingAssistDetailDTOS) != null && v.length) e == null || e.mesBuildingAssistDetailDTOS.forEach(async (i) => {
          var a, l, r, L, R;
          if (i.productionLineId = (a = i == null ? void 0 : i.productionLine) == null ? void 0 : a.id, i.numbersMap = (l = i == null ? void 0 : i.numbers) == null ? void 0 : l.map((w) => ({ id: w.number, label: w.number, boolReplace: w.boolReplace })), !C.value[e == null ? void 0 : e.configId]) {
            let w = {};
            ((r = n.info) == null ? void 0 : r.taskTypeEnum) === y.MACHINE_PART.V ? w = await F({ productType: (L = n.info) == null ? void 0 : L.taskTypeEnum }) : w = await F({ productType: (R = n.info) == null ? void 0 : R.taskTypeEnum, structureClassId: e.configId, _factoryIds: e.factoryId && [e.factoryId] || [] }), C.value[e.configId] = w;
          }
        });
        else if (!C.value[e == null ? void 0 : e.configId]) {
          let i = {};
          ((I = n.info) == null ? void 0 : I.taskTypeEnum) === y.MACHINE_PART.V ? i = await F({ productType: (T = n.info) == null ? void 0 : T.taskTypeEnum }) : i = await F({ productType: (s = n.info) == null ? void 0 : s.taskTypeEnum, structureClassId: e.configId, _factoryIds: e.factoryId && [e.factoryId] || [] }), C.value[e.configId] = i;
        }
        K.value.push(e);
      }
    } catch (k) {
      console.log("可变更的任务工单详情列表获取失败", k);
    } finally {
      Z.value = false;
    }
  }
  async function ve() {
    var o, b, c, g, h, N, u, U, H, j, z, Q, D, q, v, I, T, s, k, S;
    Z.value = true, K.value = [];
    const { content: t } = await Xe({ taskOrderId: (o = n.info) == null ? void 0 : o.taskOrderId, taskTypeEnum: ((b = n.info) == null ? void 0 : b.taskTypeEnum) & y.ASSEMBLE.V ? ((c = n.info) == null ? void 0 : c.taskTypeEnum) | y.PARENT_PART.V : (g = n.info) == null ? void 0 : g.taskTypeEnum, processId: (h = n.info) == null ? void 0 : h.process.id, ...E.value });
    for (let e = 0; e < t.length; e++) {
      t[e].isParent = true, t[e].idx = e + 1, t[e].uid = t[e].uid ? t[e].uid : Ie(), t[e].attributeType = t[e].taskTypeEnum === y.ASSEMBLE.V ? "部件" : "套料";
      for (let i = 0; i < t[e].assistProductDTOList.length; i++) {
        const a = t[e].assistProductDTOList[i];
        if (a.isParent = false, a.parentId = t[e].uid, a.idx = t[e].idx + "." + (i + 1), a.index = i, a.uid = a.uid ? a.uid : Ie(), a.assistQuantity = (N = a.totalCanAssistMete) == null ? void 0 : N.quantity, e === 0 && i === 0 || (a.groupsId = "同上"), a.areaName = (u = a.area) == null ? void 0 : u.name, a.monomerName = (U = a.monomer) == null ? void 0 : U.name, a.configId = (H = a.config) == null ? void 0 : H.id, a.numberArr = (j = a.numberList) == null ? void 0 : j.map((l) => ({ id: l, label: l })), a.numbersMap = (z = a == null ? void 0 : a.numbers) == null ? void 0 : z.map((l) => ({ id: l.number, label: l.number, boolReplace: l.boolReplace })), a.isComplete = !!((Q = a.totalCompleteMete) != null && Q.quantity && ((D = a.totalTaskMete) != null && D.quantity) && ((q = a.totalCompleteMete) == null ? void 0 : q.quantity) === ((v = a.totalTaskMete) == null ? void 0 : v.quantity)), (I = a == null ? void 0 : a.mesBuildingAssistDetailDTOS) != null && I.length) a == null || a.mesBuildingAssistDetailDTOS.forEach(async (l) => {
          var r, L, R;
          if (l.groupsId = (r = l == null ? void 0 : l.groups) == null ? void 0 : r.id, l.numbersMap = (L = l == null ? void 0 : l.numbers) == null ? void 0 : L.map((w) => ({ id: w.number, label: w.number, boolReplace: w.boolReplace })), !C.value[a == null ? void 0 : a.configId]) {
            let w = {};
            w = await F({ productType: (R = n.info) == null ? void 0 : R.taskTypeEnum, structureClassId: a.configId, _factoryIds: a.factoryId && [a.factoryId] || [] }), C.value[a.configId] = w;
          }
        });
        else if (!C.value[a == null ? void 0 : a.configId]) {
          let l = {};
          l = await F({ productType: (T = n.info) == null ? void 0 : T.taskTypeEnum, structureClassId: a.configId, _factoryIds: a.factoryId && [a.factoryId] || [] }), C.value[a.configId] = l;
        }
      }
      t[e].areaName = (s = t[e].area) == null ? void 0 : s.name, t[e].monomerName = (k = t[e].monomer) == null ? void 0 : k.name, t[e].assistQuantity = (S = t[e].totalCanAssistMete) == null ? void 0 : S.quantity, t[e].children = t[e].assistProductDTOList;
    }
    K.value = t;
  }
  function qe() {
    X.value = false, le.value = true, ge();
  }
  async function ge() {
    var b;
    pe.value = true;
    const { validResult: t, dealList: o } = Le(ee.value);
    if (t) {
      if ((b = n.info.nextProcessList) != null && b.length && !le.value) {
        X.value = true, W.value = n.info.nextProcessList.map((c) => c.id);
        return;
      }
      try {
        const c = Te(o);
        Ne(c), console.log("copyDealList:", c);
        const g = c == null ? void 0 : c.map((h) => ({ artifactTaskId: h.artifactTaskId, taskProcessId: h.id, quantity: h.assistQuantity, productionLineId: h.productionLineId, nextProcessIds: W.value }));
        await Ye(g), ze({ title: "工序协同保存成功", type: "success", duration: 2500 }), de(), oe("success");
      } catch (c) {
        console.log("保存工序协同报错", c);
      } finally {
        pe.value = false;
      }
    }
  }
  function Be() {
    x(), oe("success");
  }
  function Oe() {
    x();
  }
  function he(t) {
    $.value = {}, ae.value = true, $.value = Te(t), $.value.productionLineId = void 0, Y.value = t != null && t.mesBuildingAssistDetailDTOS ? t == null ? void 0 : t.mesBuildingAssistDetailDTOS : [];
  }
  return (t, o) => {
    var D, q;
    const b = Qe, c = J("common-button"), g = Ge, h = J("common-radio-button"), N = Ke, u = Fe, U = J("common-input-number"), H = We, j = J("common-table"), z = J("common-drawer"), Q = $e;
    return _(), V(z, { ref_key: "drawerRef", ref: re, title: `工序协同【${(q = (D = n.info) == null ? void 0 : D.process) == null ? void 0 : q.name}】`, modelValue: p(ne), "onUpdate:modelValue": o[10] || (o[10] = (v) => je(ne) ? ne.value = v : null), direction: "rtl", "before-close": p(de), size: "100%" }, { titleAfter: m(() => {
      var v;
      return [d(b, { effect: "plain" }, { default: m(() => {
        var I, T, s, k;
        return [B(" 项目：" + M((T = (I = P.currentInfo) == null ? void 0 : I.project) == null ? void 0 : T.serialNumber) + " - " + M((k = (s = P.currentInfo) == null ? void 0 : s.project) == null ? void 0 : k.shortName), 1)];
      }), _: 1 }), ((v = n.info) == null ? void 0 : v.taskTypeEnum) !== p(y).MACHINE_PART.V ? (_(), V(b, { key: 0, effect: "plain" }, { default: m(() => {
        var I, T;
        return [B(" 原生产线：" + M((I = P.info.workshop) == null ? void 0 : I.name) + ">" + M((T = P.info.productionLine) == null ? void 0 : T.name), 1)];
      }), _: 1 })) : A("", true)];
    }), titleRight: m(() => {
      var v;
      return [d(c, { size: "default", type: "success", onClick: ge, disabled: !((v = ee.value) != null && v.length) }, { default: m(() => o[11] || (o[11] = [B("批量办理【协同班组】")])), _: 1, __: [11] }, 8, ["disabled"])];
    }), content: m(() => {
      var v, I, T;
      return [G("div", ut, [d(g, { modelValue: E.value.serialNumber, "onUpdate:modelValue": o[0] || (o[0] = (s) => E.value.serialNumber = s), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: te(x, ["enter"]) }, null, 8, ["modelValue"]), d(g, { modelValue: E.value.specification, "onUpdate:modelValue": o[1] || (o[1] = (s) => E.value.specification = s), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: te(x, ["enter"]) }, null, 8, ["modelValue"]), O.value ? (_(), V(g, { key: 0, modelValue: E.value.artifactSerialNumber, "onUpdate:modelValue": o[2] || (o[2] = (s) => E.value.artifactSerialNumber = s), size: "default", placeholder: "输入构件编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: te(x, ["enter"]) }, null, 8, ["modelValue"])) : A("", true), O.value ? (_(), V(g, { key: 1, modelValue: E.value.artifactSpecification, "onUpdate:modelValue": o[3] || (o[3] = (s) => E.value.artifactSpecification = s), size: "default", placeholder: "输入构件规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: te(x, ["enter"]) }, null, 8, ["modelValue"])) : A("", true), d(h, { type: "enum", modelValue: E.value.assistEnum, "onUpdate:modelValue": o[4] || (o[4] = (s) => E.value.assistEnum = s), options: ue.ENUM, "show-option-all": "", class: "filter-item", onChange: x }, null, 8, ["modelValue", "options"]), d(c, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: ie(x, ["stop"]) }, { default: m(() => o[12] || (o[12] = [B("搜索")])), _: 1, __: [12] }), d(c, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: ie(fe, ["stop"]) }, { default: m(() => o[13] || (o[13] = [B(" 重置 ")])), _: 1, __: [13] }), ((v = n.info) == null ? void 0 : v.taskTypeEnum) === p(y).ASSEMBLE.V ? (_(), V(N, { key: 2, style: { "margin-left": "6px" }, modelValue: O.value, "onUpdate:modelValue": o[5] || (o[5] = (s) => O.value = s), onChange: De }, { default: m(() => o[14] || (o[14] = [B(" 按构件查看 ")])), _: 1, __: [14] }, 8, ["modelValue"])) : A("", true)]), !O.value || ((I = n.info) == null ? void 0 : I.taskTypeEnum) !== p(y).ASSEMBLE.V ? He((_(), V(j, { key: 0, data: K.value, "max-height": p(ce), "data-format": ke.value, "show-empty-symbol": false, "cell-class-name": p(ye), onSelectionChange: Ae, style: { width: "100%" }, ref_key: "tableRef", ref: Ee }, { default: m(() => {
        var s, k, S, e, i, a;
        return [d(u, { type: "selection", width: "55", align: "center", selectable: Pe }), d(u, { label: "序号", type: "index", align: "center", width: "60" }), ((s = n.info) == null ? void 0 : s.taskTypeEnum) !== p(y).MACHINE_PART.V ? (_(), V(u, { key: 0, prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "100px", align: "center" })) : A("", true), ((k = n.info) == null ? void 0 : k.taskTypeEnum) !== p(y).MACHINE_PART.V ? (_(), V(u, { key: 1, prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : A("", true), ((S = n.info) == null ? void 0 : S.taskTypeEnum) === p(y).MACHINE_PART.V ? (_(), V(u, { key: 2, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : A("", true), ((e = n.info) == null ? void 0 : e.taskTypeEnum) === p(y).MACHINE_PART.V ? (_(), V(u, { key: 3, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: m(({ row: l }) => [d(b, { type: l.attributeType === "部件" ? "warning" : "success" }, { default: m(() => [B(M(l.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : A("", true), ((i = n.info) == null ? void 0 : i.taskTypeEnum) !== p(y).MACHINE_PART.V ? (_(), V(u, { key: 4, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : A("", true), d(u, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), ((a = n.info) == null ? void 0 : a.taskTypeEnum) !== p(y).MACHINE_PART.V ? (_(), V(u, { key: 5, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : A("", true), d(u, { align: "center", prop: "totalTaskMete.quantity", "show-overflow-tooltip": true, label: "任务数（件）" }, { default: m(({ row: l }) => {
          var r;
          return [G("span", null, M(((r = l.totalTaskMete) == null ? void 0 : r.quantity) || 0), 1)];
        }), _: 1 }), d(u, { align: "center", prop: "totalTaskMete.netWeight", "show-overflow-tooltip": true, label: "任务总净重（kg）" }, { default: m(({ row: l }) => {
          var r;
          return [G("span", null, M(((r = l.totalTaskMete) == null ? void 0 : r.netWeight) || 0), 1)];
        }), _: 1 }), d(u, { align: "center", prop: "totalCompleteMete.quantity", "show-overflow-tooltip": true, label: "完成数（件）" }, { default: m(({ row: l }) => {
          var r;
          return [G("span", null, M(((r = l.totalCompleteMete) == null ? void 0 : r.quantity) || 0), 1)];
        }), _: 1 }), d(u, { align: "center", prop: "totalCompleteMete.netWeight", "show-overflow-tooltip": true, label: "完成总净重（kg）" }, { default: m(({ row: l }) => {
          var r;
          return [G("span", null, M(((r = l.totalCompleteMete) == null ? void 0 : r.netWeight) || 0), 1)];
        }), _: 1 }), d(u, { align: "center", prop: "totalAssistQuantity", "show-overflow-tooltip": true, label: "已协同数量" }, { default: m(({ row: l }) => [G("span", null, M(l.totalAssistQuantity || 0), 1)]), _: 1 }), d(u, { align: "center", prop: "totalCanAssistMete.quantity", "show-overflow-tooltip": true, label: "可协同数量" }, { default: m(({ row: l }) => {
          var r;
          return [G("span", null, M((r = l.totalCanAssistMete) == null ? void 0 : r.quantity), 1)];
        }), _: 1 }), d(u, { align: "center", prop: "assistQuantity", "show-overflow-tooltip": true, label: "[批量办理]协同数量", width: "140px" }, { default: m(({ row: { sourceRow: l } }) => {
          var r;
          return [d(U, { modelValue: l.assistQuantity, "onUpdate:modelValue": (L) => l.assistQuantity = L, step: 1, controls: false, min: 0, max: (r = l.totalCanAssistMete) == null ? void 0 : r.quantity, placeholder: "协同数量", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])];
        }), _: 1 }), d(u, { "show-overflow-tooltip": true, prop: "productionLineId", label: "协同班组", "min-width": "150px", align: "center" }, { default: m(({ row: { sourceRow: l }, $index: r }) => {
          var L;
          return [d(H, { modelValue: l.productionLineId, "onUpdate:modelValue": (R) => l.productionLineId = R, options: (L = C.value[l.configId]) == null ? void 0 : L.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": "", disabled: l.isComplete, filterable: "", clearable: "", placeholder: r === 0 ? "请选择生产线" : "同上", style: { width: "100%" }, onChange: (R) => Re(R, l, r) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "placeholder", "onChange"])];
        }), _: 1 }), d(u, { align: "center", "show-overflow-tooltip": true, label: "操作" }, { default: m(({ row: l }) => [d(c, { size: "default", type: "success", onClick: ie((r) => he(l), ["stop"]) }, { default: m(() => o[15] || (o[15] = [B("办理")])), _: 2, __: [15] }, 1032, ["onClick"])]), _: 1 })];
      }), _: 1 }, 8, ["data", "max-height", "data-format", "cell-class-name"])), [[Q, Z.value]]) : A("", true), O.value && ((T = n.info) == null ? void 0 : T.taskTypeEnum) === p(y).ASSEMBLE.V ? (_(), V(p(it), { key: 1, tableData: K.value, classIdGroupsObj: C.value, wrongCellMask: p(ye), maxHeight: p(ce), onDeal: he, onSelect: Ce }, null, 8, ["tableData", "classIdGroupsObj", "wrongCellMask", "maxHeight"])) : A("", true), d(p(ot), { visible: me.value, "onUpdate:visible": o[6] || (o[6] = (s) => me.value = s), info: P.info, list: _e.value, onSuccess: Oe }, null, 8, ["visible", "info", "list"]), d(p(nt), { visible: ae.value, "onUpdate:visible": o[7] || (o[7] = (s) => ae.value = s), "detail-data": $.value, "detail-list": Y.value, "next-process-list": P.info.nextProcessList, classIdGroupsObj: C.value, onSuccess: Be }, null, 8, ["visible", "detail-data", "detail-list", "next-process-list", "classIdGroupsObj"]), d(p(st), { visible: X.value, "onUpdate:visible": o[8] || (o[8] = (s) => X.value = s), modelValue: W.value, "onUpdate:modelValue": o[9] || (o[9] = (s) => W.value = s), "next-process-list": P.info.nextProcessList, onNextProcessAssistSelectConfirm: qe }, null, 8, ["visible", "modelValue", "next-process-list"])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, It = Ze(rt, [["__scopeId", "data-v-ce18bfff"]]);
export {
  It as default
};
