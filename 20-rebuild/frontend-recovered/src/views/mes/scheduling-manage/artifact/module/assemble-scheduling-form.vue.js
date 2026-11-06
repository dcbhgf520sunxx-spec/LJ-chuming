import { ref as d } from "vue";
import { inject as Re } from "vue";
import { reactive as Qe } from "vue";
import { computed as ee } from "vue";
import { watch as ue } from "vue";
import { nextTick as ce } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as He } from "vue";
import { openBlock as L } from "vue";
import { createBlock as T } from "vue";
import { withCtx as i } from "vue";
import { createVNode as n } from "vue";
import { unref as g } from "vue";
import { createTextVNode as C } from "vue";
import { withDirectives as te } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as h } from "vue";
import { createElementBlock as de } from "vue";
import { Fragment as Pe } from "vue";
import { renderList as qe } from "vue";
import { withModifiers as pe } from "vue";
import { createCommentVNode as V } from "vue";
import { isRef as Oe } from "vue";
import W from "moment";
import { ElMessageBox as Ue } from "element-plus";
import { ElNotification as me } from "element-plus";
import { ElProgress as ze } from "element-plus";
import { ElTag as We } from "element-plus";
import { ElTableColumn as Ge } from "element-plus";
import { ElCascader as $e } from "element-plus";
import { ElDatePicker as Fe } from "element-plus";
import { ElDivider as Ke } from "element-plus";
import { vLoading as Ye } from "element-plus";
import { x as Je, y as Xe } from "../../../../../modules/artifact-f1b0ca44.js";
import { s as he } from "../../../../../modules/common-a5dc7899.js";
import { _ as Ze, a3 as et, u as tt, o as lt, b as ot, a$ as at, qs as st, ca as nt, aw as it, V as ge } from "../../../../../shared/runtime.js";
import rt from "./handle-surplus-assemble-dialog.vue.js";
const ut = { class: "wrap" }, ct = { class: "wrap-left" }, dt = { class: "wrap-left-item" }, pt = { style: { flex: "1", "overflow-y": "auto", height: "750px" } }, mt = { style: { display: "flex", "justify-content": "space-between", "align-items": "center" } }, ht = { style: { "font-size": "12px", color: "#000" } }, gt = { style: { color: "#000" } }, ft = { class: "wrap-right" }, bt = { style: { display: "flex" } }, yt = { __name: "assemble-scheduling-form", props: { visible: { type: Boolean, default: false }, artifactList: { type: Array, default: () => [] }, groupData: { type: Array, default: () => [] }, projectId: String, minAskCompleteTime: Number }, emits: ["update:visible", "task-issue-success"], setup(G, { emit: fe }) {
  et.ASSEMBLE.V;
  const le = d(), $ = fe, k = G, { visible: A, handleClose: H } = tt({ emit: $, props: k, field: "visible", showHook: Se, closeHook: xe });
  Re("curFactoryIds");
  const P = Qe({}), be = (l) => {
    const e = W(l).valueOf(), a = W().subtract(1, "days").valueOf();
    if (!k.minAskCompleteTime || !W(k.minAskCompleteTime).isValid()) return e < a;
    const u = W(k.minAskCompleteTime).valueOf();
    return e < a || e > u;
  }, { fixMaxHeight: oe, maxHeight: E } = lt({ mainBox: ".assemble-scheduling-drawer", extraBox: [".el-drawer__header", ".head-container", ".assemble-scheduling-divider"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, le), q = d(), D = d({}), ye = d([]), we = d([]), ve = d(), F = d([]), N = d(false), f = d({}), ae = d([]), K = d(void 0);
  d();
  const _ = d([]), B = ee(() => {
    var l;
    return ((l = f.value) == null ? void 0 : l.assembleList) || [];
  }), S = ee(() => {
    var l;
    return ((l = f.value) == null ? void 0 : l.otherList) || [];
  }), _e = ee(() => {
    var l;
    return !!((l = S.value) != null && l.length);
  }), M = { SCHEDULING: { K: "SCHEDULING", L: "排产模式", V: 1 }, ELIMINATE: { K: "ELIMINATE", L: "选择剔除", V: 2 } }, j = d(M.SCHEDULING.V);
  ue(() => _e.value, () => {
    ce(() => {
      oe();
    });
  }), ue(() => A.value, () => {
    A.value && Je({ projectId: k.projectId }).then(({ teamScheduledInfo: l, totalScheduledWeight: e }) => {
      ae.value = l, K.value = e;
    });
  });
  const Le = { needSchedulingQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }], prodLineId: [{ required: true, message: "请选择生产线", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, Te = /* @__PURE__ */ new Map([["prodLineId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: ke, cleanUpData: Ce, wrongCellMask: Y } = it({ rules: Le, ditto: Te });
  function Ie(l, e, a) {
    var s;
    a !== 0 && !l && (e.prodLineId = "同上");
    let u = "";
    (s = P == null ? void 0 : P[e.assembleConfigId]) == null || s.list.forEach((r) => {
      r.id === (l == null ? void 0 : l[0]) && (u = r.name);
    }), console.log(":classIdGroupsObj", P), l && e.workShopId !== (l == null ? void 0 : l[0]) && Ue.confirm(`构件生产车间为${e.workShopName}，部件为${u}，请确认!`, { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(() => {
      e.prodLineId = l;
    }).catch(() => {
      e.prodLineId = [];
    });
  }
  function Ee(l, e, a) {
    a !== 0 && !l && (e.askCompleteTime = "同上");
  }
  function Se() {
    j.value = M.SCHEDULING.V, Ne(k.artifactList), De();
  }
  function xe() {
  }
  function Ve(l) {
    _.value.push(l);
    const e = f.value.assembleList;
    for (let a = e.length - 1; a >= 0; a--) e[a].productId === l.productId && e.splice(a, 1);
  }
  const Ae = (l) => {
    f.value.assembleList.push(l);
    const e = _.value;
    for (let a = e.length - 1; a >= 0; a--) e[a].productId === l.productId && e.splice(a, 1);
  };
  async function De() {
    var l;
    try {
      q.value = true, F.value = [];
      const e = k.artifactList.map((u) => ({ id: u.id, quantity: u.schedulingQuantity })), a = await Xe(e);
      f.value.assembleList = [], f.value.unshowList = [], f.value.otherList = [];
      for (let u = 0; u < (a == null ? void 0 : a.length); u++) {
        const s = a[u];
        s.boolStructuralEnum = false, s.attributeType = "部件", s.weight = s.netWeight, s.commonLength = s.length, s.needSchedulingQuantity = s.quantity, s.boolTypesettinglEnum = false, s !== 0 && (s.prodLineId = "同上", s.askCompleteTime = "同上"), s.boolProcess ? f.value.assembleList.push(s) : (f.value.unshowList.push({ boolTypesettinglEnum: s.boolTypesettinglEnum, boolSectionSteel: s.boolSectionSteel, boolProcess: s.boolProcess, productId: s.productId, projectId: s.projectId, quantity: s.quantity, boolStructuralEnum: s.boolStructuralEnum, boolOneCode: s.boolOneCode }), f.value.otherList.push(s));
        const r = (l = s.schedulingLineTree) == null ? void 0 : l.flatMap((o) => (o.disabled = o.hasProcess, o.children = o.workshopList || [], o.workshopList.map((w) => ({ ...w, children: w.productionLineList || [], disabled: w.hasProcess }))));
        s.options = r;
      }
      we.value = [], _.value = [];
    } catch (e) {
      console.log("获取部件排产列表失败", e);
    } finally {
      q.value = false, ce(() => {
        oe();
      });
    }
  }
  function Ne(l) {
    var u, s, r, o, w;
    const e = l, a = {};
    for (let p = 0; p < e.length; p++) {
      const m = (u = e[p].productionLine) == null ? void 0 : u.id;
      ot(a[m]) && (a[m] = { prodLineId: m, label: `${(r = (s = e[p]) == null ? void 0 : s.workshop) == null ? void 0 : r.name}>${(w = (o = e[p]) == null ? void 0 : o.productionLine) == null ? void 0 : w.name}`, mergeQuantity: 0, mergeWeight: 0, ids: [], list: [] }), a[m].mergeQuantity += e[p].schedulingQuantity, a[m].mergeWeight += e[p].schedulingTotalNetWeight, a[m].ids.push({ id: e[p].id, schedulingId: e[p].id, prodLineId: m, quantity: e[p].schedulingQuantity }), a[m].list.push(e[p]);
    }
    D.value = a, ye.value = at(a);
  }
  const O = d(), J = d(false), X = d(false), R = d({});
  async function Be() {
    try {
      X.value = true;
      const l = O == null ? void 0 : O.value.handleValidate();
      if (!l) return;
      R.value.matchingDetailList = l, await he(R.value), me({ title: "保存并下发成功", type: "success", duration: 2500 }), N.value = false, $("task-issue-success"), H();
    } catch (l) {
      console.log(l, "保存多余部件处理");
    } finally {
      X.value = false;
    }
  }
  async function Me() {
    var l, e, a, u, s;
    try {
      J.value = true, R.value = {};
      let r = [], o = [], w = [], p = true;
      for (const m in D.value) {
        const I = (l = f.value) == null ? void 0 : l.assembleList, Z = ge(_.value).map((b) => ({ boolStructuralEnum: b.boolStructuralEnum, productId: b.productId, projectId: b.projectId, quantity: b.needSchedulingQuantity, boolTypesettinglEnum: b.boolTypesettinglEnum, typesettingAssembleTypeEnum: b.typesettingAssembleTypeEnum, boolSectionSteel: b.boolSectionSteel, boolProcess: b.boolProcess, boolOneCode: b.boolOneCode }));
        if (w = w.concat(Z), I != null && I.length) {
          const { validResult: b, dealList: x } = ke(I);
          if (b) {
            const Q = ge(x);
            Ce(Q);
            const U = Q.map((t) => ({ askCompleteTime: t.askCompleteTime, boolStructuralEnum: t.boolStructuralEnum, prodLineId: t.prodLineId[1], productId: t.productId, projectId: t.projectId, quantity: t.needSchedulingQuantity, boolTypesettinglEnum: t.boolTypesettinglEnum, typesettingAssembleTypeEnum: t.typesettingAssembleTypeEnum, boolSectionSteel: t.boolSectionSteel, boolProcess: t.boolProcess, boolOneCode: t.boolOneCode }));
            r = r.concat(D.value[m].ids), o = o.concat(U);
          } else {
            ve.value = D.value[m].prodLineId, p = false;
            break;
          }
        } else r = r.concat(D.value[m].ids);
        (e = f.value) != null && e.unshowList && ((u = (a = f.value) == null ? void 0 : a.unshowList) != null && u.length) && (o = o.concat((s = f.value) == null ? void 0 : s.unshowList));
      }
      if (!p) return;
      if (R.value = { artifactSchedulingList: r, assembleDetailList: o, prunedList: w }, F.value.length && !N.value) {
        N.value = true;
        return;
      }
      await he(R.value), me({ title: "任务下发成功", type: "success", duration: 2500 }), $("task-issue-success"), _.value = [], H();
    } catch (r) {
      console.log("任务下发报错", r);
    } finally {
      J.value = false;
    }
  }
  const je = ({ column: l, prop: e, order: a }) => {
    if ((e === "specification" || e === "serialNumber") && B.value.sort((u, s) => {
      const r = u[e].toLowerCase(), o = s[e].toLowerCase();
      return a === "ascending" ? r.localeCompare(o) : o.localeCompare(r);
    }), e === "commonLength") {
      const u = a === "ascending";
      B.value.sort((s, r) => u ? s[e] - r[e] : r[e] - s[e]);
    }
  };
  return (l, e) => {
    const a = z("common-button"), u = ze, s = z("common-radio-button"), r = We, o = Ge, w = $e, p = Fe, m = z("common-table"), I = Ke, se = z("common-drawer"), Z = He("permission"), b = Ye;
    return L(), T(se, { ref_key: "assembleDrawerRef", ref: le, modalClass: "assemble-scheduling-drawer", title: "部件排产", modelValue: g(A), "onUpdate:modelValue": e[2] || (e[2] = (x) => Oe(A) ? A.value = x : null), direction: "rtl", "before-close": g(H), size: "100%" }, { titleRight: i(() => [n(a, { size: "default", type: "success", onClick: g(H) }, { default: i(() => e[3] || (e[3] = [C(" 上一步【构件排产预览】 ")])), _: 1, __: [3] }, 8, ["onClick"]), te((L(), T(a, { size: "default", loading: J.value, type: "primary", onClick: Me }, { default: i(() => e[4] || (e[4] = [C(" 任务下发 ")])), _: 1, __: [4] }, 8, ["loading"])), [[Z, g(st).assembleSave]])]), content: i(() => {
      var x, Q, U;
      return [c("div", ut, [c("div", ct, [c("div", dt, "已排总量（吨）：" + h((x = K.value) == null ? void 0 : x.toFixed(2)), 1), c("div", pt, [(L(true), de(Pe, null, qe(ae.value, (t, v) => (L(), de("div", { class: "wrap-left-list", key: v }, [c("div", mt, [c("span", null, h(`${t.shopName || "-"} > ${t.lineName || "-"}`), 1), c("span", ht, h(t.scheduledQuantity) + "件", 1)]), n(u, { "text-inside": true, "stroke-width": 15, percentage: t.scheduledWeight / K.value * 100, status: "dashboard" }, { default: i(() => {
        var y;
        return [c("span", gt, h((y = t.scheduledWeight) == null ? void 0 : y.toFixed(2)) + "吨", 1)];
      }), _: 2 }, 1032, ["percentage"])]))), 128))])]), c("div", ft, [c("div", bt, [n(s, { modelValue: j.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => j.value = t), options: M, type: "enum", class: "filter-item", onChange: l.handleModeChange, style: { "margin-bottom": "10px" } }, null, 8, ["modelValue", "onChange"]), n(r, { size: "large", style: { "margin-left": "10px" } }, { default: i(() => {
        var t, v, y, ne, ie, re;
        return [c("span", null, h((y = (v = (t = G.groupData) == null ? void 0 : t[0]) == null ? void 0 : v.workshop) == null ? void 0 : y.name) + " > " + h((re = (ie = (ne = G.groupData) == null ? void 0 : ne[0]) == null ? void 0 : ie.productionLine) == null ? void 0 : re.name), 1)];
      }), _: 1 })]), te((L(), T(m, { data: B.value, "max-height": S.value.length && _.value.length ? g(E) / 3 : S.value.length || _.value.length ? g(E) / 2 : g(E), "cell-class-name": g(Y), stripe: false, style: { width: "100%" }, onSortChange: je }, { default: i(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: i(({ row: t }) => [n(r, { type: t.attributeType === "部件" ? "warning" : "success" }, { default: i(() => [C(h(t.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), n(o, { prop: "typesettingAssembleTypeEnum", "show-overflow-tooltip": true, label: "部件类型", "min-width": "100", align: "center" }, { default: i(({ row: { sourceRow: t } }) => [c("span", null, h(t.assembleConfigName), 1)]), _: 1 }), n(o, { prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: i(({ row: t }) => [c("span", null, h(t.serialNumber), 1)]), _: 1 }), n(o, { prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), n(o, { prop: "commonLength", sortable: "custom", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), n(o, { prop: "weight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), n(o, { prop: "needSchedulingQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: i(({ row: { sourceRow: t } }) => [c("span", null, h(t.needSchedulingQuantity), 1)]), _: 1 }), n(o, { "show-overflow-tooltip": true, prop: "prodLineId", label: "生产线", "min-width": "150px", align: "center" }, { default: i(({ row: { sourceRow: t }, $index: v }) => [n(w, { "popper-class": "assembly-cascader", modelValue: t.prodLineId, "onUpdate:modelValue": (y) => t.prodLineId = y, options: t.options, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: true }, filterable: "", clearable: "", style: { width: "100%" }, placeholder: v === 0 ? "请选择生产线" : "同上", onChange: (y) => Ie(y, t, v) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])]), _: 1 }), n(o, { prop: "askCompleteTime", label: "要求完成日期", align: "center", "min-width": "130px" }, { default: i(({ row: { sourceRow: t }, $index: v }) => [n(p, { modelValue: t.askCompleteTime, "onUpdate:modelValue": (y) => t.askCompleteTime = y, type: "date", "value-format": "x", style: { width: "100%" }, disabledDate: be, placeholder: v === 0 ? "需求完成日期" : "同上", onChange: (y) => Ee(y, t, v) }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder", "onChange"])]), _: 1 }), j.value === M.ELIMINATE.V ? (L(), T(o, { key: 0, label: "操作", width: "80px", align: "center" }, { default: i((t) => [n(a, { type: "primary", size: "default", onClick: pe((v) => Ve(t.row), ["stop"]) }, { default: i(() => e[5] || (e[5] = [C(" 剔除 ")])), _: 2, __: [5] }, 1032, ["onClick"])]), _: 1 })) : V("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[b, q.value]]), S.value.length ? (L(), T(I, { key: 0, class: "assemble-scheduling-divider" }, { default: i(() => e[6] || (e[6] = [c("span", { class: "title" }, "无工序部件", -1)])), _: 1, __: [6] })) : V("", true), S.value.length ? te((L(), T(m, { key: 1, data: S.value, "max-height": _.value.length ? g(E) / 3 : g(E) / 2, "cell-class-name": g(Y), stripe: false, style: { width: "100%", "margin-top": "15px" } }, { default: i(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: i(({ row: t }) => [n(r, { type: t.attributeType === "部件" ? "warning" : "success" }, { default: i(() => [C(h(t.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), n(o, { prop: "typesettingAssembleTypeEnum", "show-overflow-tooltip": true, label: "部件类型", "min-width": "100", align: "center" }, { default: i(({ row: { sourceRow: t } }) => [c("span", null, h(t.assembleConfigName), 1)]), _: 1 }), n(o, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }), n(o, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), n(o, { prop: "commonLength", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), n(o, { prop: "weight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), n(o, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[b, q.value]]) : V("", true), B.value.length || _.value.length ? (L(), T(I, { key: 2, class: "assemble-scheduling-divider" }, { default: i(() => e[7] || (e[7] = [c("span", { class: "title" }, "剔除部件", -1)])), _: 1, __: [7] })) : V("", true), B.value.length || _.value.length ? (L(), T(m, { key: 3, data: _.value, "max-height": g(E) / 3, "cell-class-name": g(Y), stripe: false, style: { width: "100%" } }, { default: i(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: i(({ row: t }) => [n(r, { type: t.attributeType === "部件" ? "warning" : "success" }, { default: i(() => [C(h(t.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), n(o, { prop: "typesettingAssembleTypeEnum", "show-overflow-tooltip": true, label: "部件类型", "min-width": "100", align: "center" }, { default: i(({ row: { sourceRow: t } }) => [c("span", null, h(t.typesettingAssembleTypeEnum ? g(nt).VL[t.typesettingAssembleTypeEnum] : "-"), 1)]), _: 1 }), n(o, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: i(({ row: t }) => [c("span", null, h(t.serialNumber), 1)]), _: 1 }), n(o, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), n(o, { prop: "commonLength", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), n(o, { prop: "weight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), n(o, { prop: "needSchedulingQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: i(({ row: { sourceRow: t } }) => [c("span", null, h(t.needSchedulingQuantity), 1)]), _: 1 }), j.value === M.ELIMINATE.V ? (L(), T(o, { key: 0, label: "操作", width: "80px", align: "center" }, { default: i((t) => [n(a, { type: "danger", size: "default", onClick: pe((v) => Ae(t.row), ["stop"]) }, { default: i(() => e[8] || (e[8] = [C(" 删除 ")])), _: 2, __: [8] }, 1032, ["onClick"])]), _: 1 })) : V("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])) : V("", true)]), n(g(rt), { ref_key: "handleSurplusRef", ref: O, visible: N.value, "onUpdate:visible": e[1] || (e[1] = (t) => N.value = t), surplusList: F.value, prodLineId: (U = (Q = k.artifactList[0]) == null ? void 0 : Q.productionLine) == null ? void 0 : U.id }, { saveBtn: i(() => [n(a, { size: "default", loading: X.value, type: "primary", onClick: Be }, { default: i(() => e[9] || (e[9] = [C(" 保存并下发 ")])), _: 1, __: [9] }, 8, ["loading"])]), _: 1 }, 8, ["visible", "surplusList", "prodLineId"])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ct = Ze(yt, [["__scopeId", "data-v-4cb97e6f"]]);
export {
  Ct as default
};
