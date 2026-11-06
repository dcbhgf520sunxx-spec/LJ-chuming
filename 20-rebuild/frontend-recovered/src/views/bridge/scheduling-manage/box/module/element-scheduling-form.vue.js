import { ref as g } from "vue";
import { inject as Le } from "vue";
import { reactive as Ee } from "vue";
import { computed as Q } from "vue";
import { watch as Ce } from "vue";
import { nextTick as le } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as ke } from "vue";
import { openBlock as L } from "vue";
import { createBlock as V } from "vue";
import { withCtx as d } from "vue";
import { createVNode as s } from "vue";
import { unref as h } from "vue";
import { createTextVNode as D } from "vue";
import { withDirectives as $ } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as _ } from "vue";
import { createElementBlock as Se } from "vue";
import { Fragment as xe } from "vue";
import { createCommentVNode as K } from "vue";
import oe from "moment";
import { isRef as Ve } from "vue";
import { ElNotification as ae } from "element-plus";
import { ElTableColumn as De } from "element-plus";
import { ElTag as Ne } from "element-plus";
import { ElCascader as Be } from "element-plus";
import { ElDatePicker as Pe } from "element-plus";
import { ElDivider as qe } from "element-plus";
import { vLoading as Re } from "element-plus";
import { l as je } from "../../../../../modules/box-3fab54f9.js";
import { s as ne } from "../../../../../modules/common-8949b382.js";
import { _ as Qe, F as Ae, u as Ue, o as Fe, aU as A, b as Y, ca as He, a$ as Oe, bW as We, aw as Ge, V as Me } from "../../../../../shared/runtime.js";
import { B as ze } from "../../../../../modules/bridge-86f96a4f.js";
import { m as se } from "../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import $e from "./handle-surplus-element-dialog.vue.js";
const Ke = { class: "head-container" }, Ye = -1, Je = { __name: "element-scheduling-form", props: { visible: { type: Boolean, default: false }, boxList: { type: Array, default: () => [] }, productionLineTypeEnum: { type: [Number, String] } }, emits: ["update:visible", "task-issue-success"], setup(ie, { emit: ue }) {
  const J = Ae.CELL.V, X = g(), U = ue, b = ie, { visible: F, handleClose: N } = Ue({ emit: U, props: b, field: "visible", showHook: ye }), Z = Le("curFactoryIds"), E = Ee({}), { fixMaxHeight: ee, maxHeight: H } = Fe({ mainBox: ".element-scheduling-drawer", extraBox: [".el-drawer__header", ".head-container", ".element-scheduling-divider"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, X), B = g(), r = g({}), O = g([]), C = g([]), I = g(), re = g([]), P = g([]), k = g(false), de = Q(() => {
    var a;
    return ((a = r.value[I.value]) == null ? void 0 : a.elementList) || [];
  }), S = Q(() => {
    var a;
    return ((a = r.value[I.value]) == null ? void 0 : a.otherList) || [];
  }), pe = Q(() => {
    var a;
    return !!((a = S.value) != null && a.length);
  }), ce = Q(() => {
    const a = [];
    for (let t = 0; t < O.value.length; t++) {
      const i = O.value[t];
      C.value.includes(i.groupsId) && a.push(i);
    }
    return a;
  });
  Ce(() => pe.value, () => {
    le(() => {
      ee();
    });
  });
  const me = { needSchedulingQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, ge = /* @__PURE__ */ new Map([["groupsId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: he, cleanUpData: fe, wrongCellMask: te } = Ge({ rules: me, ditto: ge });
  function be(a, t, i) {
    i !== 0 && !a && (t.groupsId = "同上");
  }
  function ve(a, t, i) {
    i !== 0 && !a && (t.askCompleteTime = "同上");
  }
  function ye() {
    _e(b.boxList), we();
  }
  async function we() {
    var a, t, i;
    try {
      B.value = true, P.value = [];
      const n = b.boxList.map((u) => ({ id: u.id, quantity: u.schedulingQuantity })), { elementSchedulingList: c, elementTypesetting: m, surplusElement: f } = await je(n);
      C.value = [], re.value = c;
      for (let u = 0; u < (c == null ? void 0 : c.length); u++) {
        const l = c[u];
        if (l != null && l.groupsId && r.value[l.groupsId]) {
          C.value.push(l.groupsId), r.value[l.groupsId].elementList = [], r.value[l.groupsId].unshowList = [], r.value[l.groupsId].otherList = [];
          for (let p = 0; p < ((a = l.elementList) == null ? void 0 : a.length); p++) {
            const e = l.elementList[p];
            e.boolStructuralEnum = false, e.attributeType = "单元件", e.weight = e.netWeight, e.commonLength = e.length, e.needSchedulingQuantity = e.quantity, e.boolTypesettinglEnum = false, p !== 0 && (e.groupsId = "同上", e.askCompleteTime = "同上"), !e.boolProcess || b.productionLineTypeEnum === A.INTELLECT.V && e.boolSectionSteel ? (r.value[l.groupsId].unshowList.push({ boolTypesettinglEnum: e.boolTypesettinglEnum, boolSectionSteel: e.boolSectionSteel, boolProcess: e.boolProcess, productId: e.productId, projectId: e.projectId, quantity: e.quantity, boolStructuralEnum: e.boolStructuralEnum }), r.value[l.groupsId].otherList.push({ ...e })) : r.value[l.groupsId].elementList.push({ ...e }), Y(E[e.elementConfigId]) && (E[e.elementConfigId] = await se({ productType: J, boxClassId: e.elementConfigId, _factoryIds: Z.value }));
          }
          for (let p = 0; p < ((t = l.elementTypesetting) == null ? void 0 : t.length); p++) {
            const e = m[p];
            e.productId = e.id, e.attributeType = "套料", e.weight = e.nestingNetWeight, e.commonLength = e.typesettingLength, e.boolStructuralEnum = true, e.boolTypesettinglEnum = true, e.needSchedulingQuantity = 1, (p !== 0 || (i = l.elementList) != null && i.length && p === 0) && (e.groupsId = "同上", e.askCompleteTime = "同上"), e.elementConfigId && Y(E[e.elementConfigId]) && (E[e.elementConfigId] = await se({ productType: J, boxClassId: e.elementConfigId, _factoryIds: Z.value })), b.productionLineTypeEnum === A.INTELLECT.V && e.typesettingAssembleTypeEnum === He.FINISHED.V || b.productionLineTypeEnum === A.TRADITION.V && !e.boolProcess ? (r.value[l.groupsId].unshowList.push({ boolStructuralEnum: e.boolStructuralEnum, boolTypesettinglEnum: e.boolTypesettinglEnum, typesettingAssembleTypeEnum: e.typesettingAssembleTypeEnum, boolProcess: e.boolProcess, productId: e.productId, projectId: e.projectId, quantity: e.quantity }), r.value[l.groupsId].otherList.push({ ...e })) : r.value[l.groupsId].elementList.push({ ...e });
          }
        }
      }
      b.productionLineTypeEnum & A.INTELLECT.V && (P.value = f || []), I.value = C.value[0];
    } catch (n) {
      console.log("获取单元件排产列表失败", n);
    } finally {
      B.value = false, le(() => {
        ee();
      });
    }
  }
  function _e(a) {
    var n, c, m, f;
    const t = a, i = {};
    for (let u = 0; u < t.length; u++) {
      const l = (n = t[u].groups) == null ? void 0 : n.id;
      Y(i[l]) && (i[l] = { groupsId: l, label: `${(c = t[u].workshop) == null ? void 0 : c.name}>${(m = t[u].productionLine) == null ? void 0 : m.name}>${(f = t[u].groups) == null ? void 0 : f.name}`, mergeQuantity: 0, mergeWeight: 0, ids: [], list: [] }), i[l].mergeQuantity += t[u].schedulingQuantity, i[l].mergeWeight += t[u].schedulingTotalNetWeight, i[l].ids.push({ id: t[u].id, schedulingId: t[u].id, groupsId: l, quantity: t[u].schedulingQuantity }), i[l].list.push(t[u]);
    }
    r.value = i, O.value = Oe(i);
  }
  const q = g(), W = g(false), G = g(false), T = g({});
  async function Ie() {
    try {
      G.value = true;
      const a = q == null ? void 0 : q.value.handleValidate();
      if (!a) return;
      T.value.matchingDetailList = a, await ne(T.value), ae({ title: "保存并下发成功", type: "success", duration: 2500 }), k.value = false, U("task-issue-success"), N();
    } catch (a) {
      console.log(a, "保存多余单元件处理");
    } finally {
      G.value = false;
    }
  }
  async function Te() {
    var a, t, i, n, c;
    try {
      W.value = true, T.value = {};
      let m = [], f = [], u = true;
      for (const l in r.value) {
        const p = (a = r.value[l]) == null ? void 0 : a.elementList;
        if (C.value.includes(Number(l)) && (p != null && p.length)) {
          const { validResult: e, dealList: R } = he(p);
          if (e) {
            const w = Me(R);
            fe(w);
            const j = w.map((o) => ({ askCompleteTime: o.askCompleteTime, boolStructuralEnum: o.boolStructuralEnum, groupsId: o.groupsId, productId: o.productId, projectId: o.projectId, quantity: o.needSchedulingQuantity, boolTypesettinglEnum: o.boolTypesettinglEnum, typesettingAssembleTypeEnum: o.typesettingAssembleTypeEnum, boolSectionSteel: o.boolSectionSteel, boolProcess: o.boolProcess }));
            m = m.concat(r.value[l].ids), f = f.concat(j);
          } else {
            I.value = r.value[l].groupsId, u = false;
            break;
          }
        } else m = m.concat(r.value[l].ids);
        (t = r.value[l]) != null && t.unshowList && ((n = (i = r.value[l]) == null ? void 0 : i.unshowList) != null && n.length) && (f = f.concat((c = r.value[l]) == null ? void 0 : c.unshowList));
      }
      if (!u) return;
      if (T.value = { boxSchedulingList: m, elementDetailList: f, productionLineTypeEnum: b.productionLineTypeEnum }, console.log(T.value, "saveTaskParams.value"), P.value.length && !k.value) {
        k.value = true;
        return;
      }
      await ne(T.value), ae({ title: "任务下发成功", type: "success", duration: 2500 }), U("task-issue-success"), N();
    } catch (m) {
      console.log("任务下发报错", m);
    } finally {
      W.value = false;
    }
  }
  return (a, t) => {
    const i = z("common-button"), n = De, c = Ne, m = Be, f = Pe, u = z("common-table"), l = qe, p = z("common-drawer"), e = ke("permission"), R = Re;
    return L(), V(p, { ref_key: "elementDrawerRef", ref: X, modalClass: "element-scheduling-drawer", title: "单元件排产", modelValue: h(F), "onUpdate:modelValue": t[2] || (t[2] = (w) => Ve(F) ? F.value = w : null), direction: "rtl", "before-close": h(N), size: "100%" }, { titleRight: d(() => [s(i, { size: "default", type: "success", onClick: h(N) }, { default: d(() => t[3] || (t[3] = [D(" 上一步【分段排产预览】 ")])), _: 1, __: [3] }, 8, ["onClick"]), $((L(), V(i, { size: "default", loading: W.value, type: "primary", onClick: Te }, { default: d(() => t[4] || (t[4] = [D(" 任务下发 ")])), _: 1, __: [4] }, 8, ["loading"])), [[e, h(ze).elementSave]])]), content: d(() => {
      var w, j;
      return [y("div", Ke, [s(h(We), { modelValue: I.value, "onUpdate:modelValue": t[0] || (t[0] = (o) => I.value = o), class: "filter-item", style: "width:calc(100% - 125px)", data: ce.value, itemKey: "groupsId" }, { default: d(({ item: o }) => [y("span", null, _(o.label), 1), o.groupsId !== Ye ? (L(), Se(xe, { key: 0 }, [t[5] || (t[5] = y("span", null, " - ", -1)), t[6] || (t[6] = y("span", null, "排产量：", -1)), y("span", null, _(o.mergeQuantity) + "件 / " + _(o.mergeWeight.toFixed(2)) + "kg", 1)], 64)) : K("", true)]), _: 1 }, 8, ["modelValue", "data"])]), $((L(), V(u, { data: de.value, "max-height": S.value.length ? h(H) / 2 : h(H), "cell-class-name": h(te), stripe: false, style: { width: "100%" } }, { default: d(() => [s(n, { label: "序号", type: "index", align: "center", width: "60" }), s(n, { prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: d(({ row: o }) => [s(c, { type: o.attributeType === "单元件" ? "warning" : "success" }, { default: d(() => [D(_(o.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), s(n, { prop: "elementConfigName", "show-overflow-tooltip": true, label: "单元件类型", "min-width": "100", align: "center" }), s(n, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: d(({ row: o }) => [y("span", null, _(o.serialNumber), 1)]), _: 1 }), s(n, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), s(n, { prop: "commonLength", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), s(n, { prop: "weight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), s(n, { prop: "needSchedulingQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: d(({ row: { sourceRow: o } }) => [y("span", null, _(o.needSchedulingQuantity), 1)]), _: 1 }), s(n, { "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: d(({ row: { sourceRow: o }, $index: x }) => {
        var v;
        return [s(m, { modelValue: o.groupsId, "onUpdate:modelValue": (M) => o.groupsId = M, options: (v = E[o.elementConfigId]) == null ? void 0 : v.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, filterable: "", clearable: "", style: { width: "100%" }, placeholder: x === 0 ? "请选择生产组" : "同上", onChange: (M) => be(M, o, x) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])];
      }), _: 1 }), s(n, { prop: "askCompleteTime", label: "要求完成日期", align: "center", "min-width": "130px" }, { default: d(({ row: { sourceRow: o }, $index: x }) => [s(f, { modelValue: o.askCompleteTime, "onUpdate:modelValue": (v) => o.askCompleteTime = v, type: "date", size: "default", "value-format": "x", style: { width: "100%" }, disabledDate: (v) => h(oe)(v).valueOf() < h(oe)().subtract(1, "days").valueOf(), placeholder: x === 0 ? "需求完成日期" : "同上", onChange: (v) => ve(v, o, x) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "placeholder", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[R, B.value]]), S.value.length ? (L(), V(l, { key: 0, class: "element-scheduling-divider" }, { default: d(() => t[7] || (t[7] = [y("span", { class: "title" }, "型材", -1)])), _: 1, __: [7] })) : K("", true), S.value.length ? $((L(), V(u, { key: 1, data: S.value, "max-height": h(H) / 2, "cell-class-name": h(te), stripe: false, style: { width: "100%", "margin-top": "15px" } }, { default: d(() => [s(n, { label: "序号", type: "index", align: "center", width: "60" }), s(n, { prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: d(({ row: o }) => [s(c, { type: o.attributeType === "单元件" ? "warning" : "success" }, { default: d(() => [D(_(o.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), s(n, { prop: "elementConfigName", "show-overflow-tooltip": true, label: "单元件类型", "min-width": "100", align: "center" }), s(n, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }), s(n, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), s(n, { prop: "commonLength", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), s(n, { prop: "weight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), s(n, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[R, B.value]]) : K("", true), s(h($e), { ref_key: "handleSurplusRef", ref: q, visible: k.value, "onUpdate:visible": t[1] || (t[1] = (o) => k.value = o), surplusList: P.value, groupsId: (j = (w = b.boxList[0]) == null ? void 0 : w.groups) == null ? void 0 : j.id }, { saveBtn: d(() => [s(i, { size: "default", loading: G.value, type: "primary", onClick: Ie }, { default: d(() => t[8] || (t[8] = [D(" 保存并下发 ")])), _: 1, __: [8] }, 8, ["loading"])]), _: 1 }, 8, ["visible", "surplusList", "groupsId"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, nt = Qe(Je, [["__scopeId", "data-v-12457108"]]);
export {
  nt as default
};
