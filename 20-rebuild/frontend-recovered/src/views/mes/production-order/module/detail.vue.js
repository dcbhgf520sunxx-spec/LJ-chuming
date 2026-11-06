import { ref as c } from "vue";
import { watch as A } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as s } from "vue";
import { createBlock as y } from "vue";
import { withCtx as d } from "vue";
import { unref as n } from "vue";
import { withDirectives as j } from "vue";
import { createTextVNode as B } from "vue";
import { createCommentVNode as z } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as ne } from "vue";
import { toDisplayString as k } from "vue";
import { createElementBlock as f } from "vue";
import se from "moment";
import { Fragment as ie } from "vue";
import { isRef as de } from "vue";
import { ElMessage as ue } from "element-plus";
import { ElMessageBox as ce } from "element-plus";
import { ElNotification as pe } from "element-plus";
import { ElTableColumn as me } from "element-plus";
import { ElDatePicker as fe } from "element-plus";
import { ElForm as he } from "element-plus";
import { vLoading as we } from "element-plus";
import { s as ge, u as ye } from "../../../../modules/production-order-028b54f6.js";
import { u as ke, o as _e, a3 as be, G as De, c3 as ve, z as Ie, bV as H, D as U, p as $, aw as Ve, oV as Ce, i as Se } from "../../../../shared/runtime.js";
import { u as Te } from "../../../../modules/use-product-lines-79a95221.js";
import { j as F } from "../../../../modules/judgeSameValue-9683bdce.js";
import je from "./structure-list.vue.js";
import "./type-detail.vue.js";
import "./components/Panel/index.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Be = { class: "project-name" }, xe = { key: 0 }, Le = { key: 1 }, Ne = { key: 1 }, We = { key: 1 }, Ee = { key: 0 }, Oe = { key: 1 }, Ge = { __name: "detail", props: { currentId: { type: [String, Number], default: void 0 }, modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(V, { emit: P }) {
  const x = P, D = V, { visible: C, handleClose: L } = ke({ emit: x, props: D, closeHook: re }), { productLines: N } = Te(), h = c(false), W = c([]), u = c([]), E = c([]), O = c(), q = c(false), w = c(false), S = c([]), G = c(), _ = c(false), { maxHeight: J } = _e({ mainBox: ".schedule-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, minHeight: 300 }, () => O.value.loaded);
  A(N, (e) => {
    Z(N);
  }, { immediate: true, deep: true }), A(() => D.modelValue, (e) => {
    e && (w.value = false, oe());
  }, { deep: true, immediate: true });
  const K = { workshopId: [{ validator: (e, o) => o.endDate ? !!(Se(e) || o.endDate === o.closingDate) : true, message: "请选择车间", trigger: "change" }] }, { tableValidate: Y, wrongCellMask: Q } = Ve({ rules: K });
  function X({ row: e, column: o, rowIndex: t, columnIndex: a }) {
    if (a === 0 || a === 1 || a === 6) return { rowspan: a === 1 || a === 6 ? e.monomerSpan || 0 : e.projectSpan || 0, colspan: 1 };
  }
  function Z(e) {
    E.value = [];
    const o = [];
    try {
      e && (JSON.parse(JSON.stringify(e.value)).map((a) => {
        a.disabled = true, a.workshopList.map((r) => {
          r.children = r.productionLineList.filter((p) => p.productType === be.ARTIFACT.V) || [], o.push(r);
        }), a.children = a.workshopList || [];
      }), E.value = o);
    } catch (t) {
      console.log("获取工厂车间生产线树失败", t);
    }
  }
  async function ee() {
    try {
      const { content: e } = await Ce({ boolEnabledEnum: true });
      W.value = e || [];
    } catch (e) {
      console.log("获取车间信息失败", e);
    }
  }
  ee();
  function te(e) {
    e.workshopId ? e.startDate = (/* @__PURE__ */ new Date()).getTime() : e.startDate = void 0;
  }
  function ae(e) {
    e.endDate ? e.startDate = (/* @__PURE__ */ new Date()).getTime() : e.startDate = void 0;
  }
  async function oe() {
    if (D.currentId) try {
      let { content: e } = await ge({ projectId: D.currentId });
      if (u.value = [], !Array.isArray(e) || e.length === 0) {
        S.value = [];
        return;
      }
      const o = [];
      e = e.map((t) => {
        var a;
        return t.totalWeight = (a = t.monomer) == null ? void 0 : a.netWeight, t;
      }), e.map((t) => {
        var a, r, p, g, v, b;
        t.projectId = (a = t.project) == null ? void 0 : a.id, t.monomerId = (r = t.monomer) == null ? void 0 : r.id, t.areaId = (p = t.area) == null ? void 0 : p.id, t.factoryId = (g = t.factory) == null ? void 0 : g.id, t.workshopId = (v = t.workshop) == null ? void 0 : v.id, t.productionLineId = (b = t.productionLine) == null ? void 0 : b.id, o.indexOf(t.monomerId) < 0 && o.push(t.monomerId);
      });
      for (let t = 0; t < o.length; t++) {
        const a = e.filter((r) => r.monomerId === o[t]);
        a[0].monomerSpan = a.length, u.value.push(...a);
      }
      u.value[0].projectSpan = u.value.length, S.value = JSON.parse(JSON.stringify(u.value));
    } catch (e) {
      console.error("生产订单详情失败", e);
    }
  }
  async function le() {
    const { validResult: e, dealList: o } = Y(u.value);
    if (e) u.value = o;
    else return e;
    h.value = true;
    try {
      const t = [];
      let a = false;
      if (u.value.map((r) => {
        r.closingDate && r.endDate > r.closingDate && (a = true);
        const p = S.value.find((g) => g.id === r.id);
        (!F(p.endDate, r.endDate) || !F(p.workshopId, r.workshopId)) && t.push({ id: r.id, areaId: r.areaId, endDate: r.endDate || null, factoryId: r.factoryId || null, monomerId: r.monomerId, projectId: r.projectId, startDate: r.startDate || null, workshopId: r.workshopId || null, areaBatchId: r.areaBatch.id || null });
      }), !t.length) {
        ue.error("请至少提交或更改一条信息"), h.value = false;
        return;
      }
      a && await ce.confirm("排期计划大于项目主计划，是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ye(t), h.value = false, pe({ title: "提交成功", type: "success" }), x("success"), L();
    } catch (t) {
      h.value = false, console.log("生产订单排期", t);
    }
  }
  function re() {
    u.value = [];
  }
  return (e, o) => {
    const t = I("common-button"), a = me, r = I("common-select"), p = fe, g = I("common-table"), v = he, b = I("common-drawer"), T = we;
    return s(), y(b, { ref_key: "drawerRef", ref: O, "append-to-body": "", "close-on-click-modal": false, "before-close": n(L), modelValue: n(C), "onUpdate:modelValue": o[4] || (o[4] = (l) => de(C) ? C.value = l : null), title: "计划排期", "wrapper-closable": false, size: "80%", "custom-class": "schedule-detail" }, { titleRight: d(() => [!w.value && n(De)(V.permission.edit) ? j((s(), y(t, { key: 0, size: "default", type: "warning", onClick: o[0] || (o[0] = (l) => w.value = true) }, { default: d(() => o[5] || (o[5] = [B(" 创建计划 ")])), _: 1, __: [5] })), [[T, h.value]]) : z("", true), w.value ? j((s(), y(t, { key: 1, size: "default", type: "primary", onClick: o[1] || (o[1] = (l) => le(n(ve).PASS.V)) }, { default: d(() => o[6] || (o[6] = [B(" 提交")])), _: 1, __: [6] })), [[T, h.value]]) : z("", true)]), content: d(() => [i(v, { ref: "formRef", size: "default", "label-width": "130px" }, { default: d(() => [j((s(), y(g, { data: u.value, "return-source-data": "", showEmptySymbol: false, "span-method": X, "max-height": n(J), "cell-class-name": n(Q), stripe: false }, { default: d(() => [i(a, { key: "project", prop: "project", label: "项目", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: d((l) => [ne("span", Be, k(n(Ie)(l.row.project)), 1)]), _: 1 }), i(a, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true }), i(a, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true }), i(a, { key: "areaBatch.name", prop: "areaBatch.name", label: "批次", align: "center", "show-overflow-tooltip": true }), i(a, { key: "quantity", prop: "quantity", label: "数量（件）", align: "center", "show-overflow-tooltip": true }), i(a, { key: "totalNetWeight", prop: "totalNetWeight", label: "重量（kg）", align: "center", "show-overflow-tooltip": true }, { default: d((l) => [l.row.totalNetWeight ? (s(), f("span", xe, k(n(H)(l.row.totalNetWeight, n(U).COM_WT__KG)), 1)) : (s(), f("span", Le, "-"))]), _: 1 }), i(a, { key: "totalWeight", prop: "totalWeight", label: "合计（kg）", align: "center", "show-overflow-tooltip": true }, { default: d((l) => [l.row.totalWeight ? (s(), f("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: o[2] || (o[2] = (m) => _.value = true) }, k(n(H)(l.row.totalWeight, n(U).COM_WT__KG)), 1)) : (s(), f("span", Ne, "-"))]), _: 1 }), i(a, { key: "closingDate", prop: "closingDate", label: "截止日期", align: "center", "show-overflow-tooltip": true }, { default: d((l) => [B(k(l.row.closingDate ? n($)(l.row.closingDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), i(a, { key: "constructionDay", prop: "constructionDay", label: "工期（天）", align: "center" }), i(a, { key: "workshopId", prop: "workshopId", label: "选择车间", align: "center", width: "290" }, { default: d((l) => {
      var m, R;
      return [w.value ? (s(), y(r, { key: 0, modelValue: l.row.workshopId, "onUpdate:modelValue": (M) => l.row.workshopId = M, options: W.value, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择车间", onChange: (M) => te(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (s(), f("span", We, k(((R = (m = l.row) == null ? void 0 : m.workshop) == null ? void 0 : R.name) || "-"), 1))];
    }), _: 1 }), i(a, { key: "endDate", prop: "endDate", label: "交货日期", align: "center", width: "250" }, { default: d((l) => [w.value ? (s(), y(p, { key: 0, modelValue: l.row.endDate, "onUpdate:modelValue": (m) => l.row.endDate = m, type: "date", "value-format": "x", placeholder: "请选择交货日期", disabledDate: (m) => n(se)(m).valueOf() > l.row.closingDate.valueOf(), onChange: (m) => ae(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "onChange"])) : (s(), f(ie, { key: 1 }, [l.row.endDate ? (s(), f("span", Ee, k(`${n($)(l.row.endDate, "{y}年{m}月{d}日")}`), 1)) : (s(), f("span", Oe, "-"))], 64))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[T, q.value]])]), _: 1 }, 512), i(b, { "append-to-body": "", ref_key: "detailRef", ref: G, modelValue: _.value, "onUpdate:modelValue": o[3] || (o[3] = (l) => _.value = l), top: "10vh", "before-close": () => {
      _.value = false;
    }, title: "构零件清单", "wrapper-closable": false, "custom-class": "artifact-tree-drawer", size: "90%" }, { content: d(() => [i(n(je), { drawerVisible: _.value, currentId: V.currentId }, null, 8, ["drawerVisible", "currentId"])]), _: 1 }, 8, ["modelValue", "before-close"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} };
export {
  Ge as default
};
