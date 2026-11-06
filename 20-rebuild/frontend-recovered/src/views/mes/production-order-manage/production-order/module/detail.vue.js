import { ref as p } from "vue";
import { computed as le } from "vue";
import { watch as M } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as r } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as s } from "vue";
import { unref as i } from "vue";
import { withDirectives as j } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as U } from "vue";
import { createVNode as d } from "vue";
import { createElementVNode as ne } from "vue";
import { toDisplayString as b } from "vue";
import { createElementBlock as m } from "vue";
import { Fragment as re } from "vue";
import { isRef as ie } from "vue";
import { ElMessage as se } from "element-plus";
import { ElMessageBox as de } from "element-plus";
import { ElNotification as ue } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElCascader as pe } from "element-plus";
import { ElDatePicker as me } from "element-plus";
import { ElForm as fe } from "element-plus";
import { vLoading as he } from "element-plus";
import { s as we, u as ge } from "../../../../../modules/production-order-028b54f6.js";
import { u as ye, o as _e, G as be, c3 as ke, z as Ie, bV as q, D as z, p as P, aw as De, i as Ve } from "../../../../../shared/runtime.js";
import { u as ve } from "../../../../../modules/use-product-lines-79a95221.js";
import { j as $ } from "../../../../../modules/judgeSameValue-9683bdce.js";
import Le from "./structure-list.vue.js";
import "./type-detail.vue.js";
import "./components/Panel/index.vue.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const Ce = { class: "project-name" }, Se = { key: 0 }, je = { key: 1 }, xe = { key: 1 }, Ne = { key: 1 }, Te = { key: 0 }, Be = { key: 1 }, He = { __name: "detail", props: { currentId: { type: [String, Number], default: void 0 }, modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(L, { emit: H }) {
  const N = H, D = L, { visible: C, handleClose: T } = ye({ emit: N, props: D }), { productLines: B } = ve(), f = p(false), u = p([]), V = p([]), W = p(), F = p(false), h = p(false), E = p([]), G = p(), k = p(false), J = le(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), { maxHeight: A } = _e({ mainBox: ".schedule-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, minHeight: 300 }, () => W.value.loaded);
  M(B, (o) => {
    Z(B);
  }, { immediate: true, deep: true }), M(() => D.modelValue, (o) => {
    o && (h.value = false, ae());
  }, { deep: true, immediate: true });
  const K = { line: [{ validator: (o, t) => t.endDate ? !!Ve(o) : true, message: "请选择车间", trigger: "change" }] }, { tableValidate: Q, wrongCellMask: X } = De({ rules: K });
  function Y({ row: o, column: t, rowIndex: n, columnIndex: e }) {
    if (e === 0 || e === 1 || e === 5) return { rowspan: e === 0 || e === 5 ? o.projectSpan || 0 : o.monomerSpan || 0, colspan: 1 };
  }
  function Z(o) {
    V.value = [];
    const t = [];
    try {
      o && (JSON.parse(JSON.stringify(o.value)).map((e) => {
        e.disabled = true, e.workshopList.map((l) => {
          l.children = l.productionLineList || [], t.push(l);
        }), e.children = e.workshopList || [];
      }), V.value = t);
    } catch (n) {
      console.log("获取工厂车间生产线树失败", n);
    }
  }
  function ee(o, t) {
    if (o && o.length) {
      const n = V.value.find((e) => e.id === o[0]);
      t.factoryId = n.factoryId, t.workshopId = o[0], t.productionLineId = o[1] || void 0;
    } else t.factoryId = void 0, t.workshopId = void 0, t.productionLineId = void 0;
  }
  function te(o) {
    o.endDate ? o.startDate = (/* @__PURE__ */ new Date()).getTime() : o.startDate = void 0;
  }
  async function ae() {
    if (u.value = [], !!D.currentId) try {
      const { content: o } = await we({ projectId: D.currentId }), t = [];
      let n = 0;
      o.map((e) => {
        var l, c, w, v, I, g;
        n += e.totalNetWeight, e.line = [], e.projectId = (l = e.project) == null ? void 0 : l.id, e.monomerId = (c = e.monomer) == null ? void 0 : c.id, e.areaId = (w = e.area) == null ? void 0 : w.id, e.factoryId = (v = e.factory) == null ? void 0 : v.id, e.workshopId = (I = e.workshop) == null ? void 0 : I.id, e.productionLineId = (g = e.productionLine) == null ? void 0 : g.id, e.productionLineId ? e.line.push(e.workshopId, e.productionLineId) : e.workshopId && e.line.push(e.workshopId), t.indexOf(e.monomerId) < 0 && t.push(e.monomerId);
      });
      for (let e = 0; e < t.length; e++) {
        const l = o.filter((c) => c.monomerId === t[e]);
        l[0].monomerSpan = l.length, u.value.push(...l);
      }
      u.value[0].projectSpan = u.value.length, u.value[0].totalWeight = n, E.value = JSON.parse(JSON.stringify(u.value));
    } catch (o) {
      console.log("生产订单详情失败", o);
    }
  }
  async function oe() {
    const { validResult: o, dealList: t } = Q(u.value);
    if (o) u.value = t;
    else return o;
    f.value = true;
    try {
      const n = [];
      let e = false;
      if (u.value.map((l) => {
        l.closingDate && l.endDate > l.closingDate && (e = true);
        const c = E.value.find((w) => w.areaId === l.areaId);
        (!$(c.endDate, l.endDate) || !$(c.line, l.line)) && n.push({ areaId: l.areaId, endDate: l.endDate || null, factoryId: l.factoryId || null, monomerId: l.monomerId, productionLineId: l.productionLineId || null, projectId: l.projectId, startDate: l.startDate || null, workshopId: l.workshopId || null });
      }), !n.length) {
        se.error("请至少提交或更改一条信息"), f.value = false;
        return;
      }
      e && await de.confirm("排期计划大于项目主计划，是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ge(n), f.value = false, ue({ title: "提交成功", type: "success" }), N("success"), T();
    } catch (n) {
      f.value = false, console.log("生产订单排期", n);
    }
  }
  return (o, t) => {
    const n = S("common-button"), e = ce, l = pe, c = me, w = S("common-table"), v = fe, I = S("common-drawer"), g = he;
    return r(), _(I, { ref_key: "drawerRef", ref: W, "append-to-body": "", "close-on-click-modal": false, "before-close": i(T), modelValue: i(C), "onUpdate:modelValue": t[4] || (t[4] = (a) => ie(C) ? C.value = a : null), title: "计划排期", "wrapper-closable": false, size: "80%", "custom-class": "schedule-detail" }, { titleRight: s(() => [!h.value && i(be)(L.permission.edit) ? j((r(), _(n, { key: 0, size: "default", type: "warning", onClick: t[0] || (t[0] = (a) => h.value = true) }, { default: s(() => t[5] || (t[5] = [x("创建计划")])), _: 1, __: [5] })), [[g, f.value]]) : U("", true), h.value ? j((r(), _(n, { key: 1, size: "default", type: "primary", onClick: t[1] || (t[1] = (a) => oe(i(ke).PASS.V)) }, { default: s(() => t[6] || (t[6] = [x("提交")])), _: 1, __: [6] })), [[g, f.value]]) : U("", true)]), content: s(() => [d(v, { ref: "formRef", size: "default", "label-width": "130px" }, { default: s(() => [j((r(), _(w, { data: u.value, "return-source-data": "", showEmptySymbol: false, "span-method": Y, "max-height": i(A), "cell-class-name": i(X), stripe: false }, { default: s(() => [d(e, { key: "project", prop: "project", label: "项目", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: s((a) => [ne("span", Ce, b(i(Ie)(a.row.project)), 1)]), _: 1 }), d(e, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true }), d(e, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true }), d(e, { key: "quantity", prop: "quantity", label: "数量（件）", align: "center", "show-overflow-tooltip": true }), d(e, { key: "totalNetWeight", prop: "totalNetWeight", label: "重量（kg）", align: "center", "show-overflow-tooltip": true }, { default: s((a) => [a.row.totalNetWeight ? (r(), m("span", Se, b(i(q)(a.row.totalNetWeight, i(z).COM_WT__KG)), 1)) : (r(), m("span", je, "-"))]), _: 1 }), d(e, { key: "totalWeight", prop: "totalWeight", label: "合计（kg）", align: "center", "show-overflow-tooltip": true }, { default: s((a) => [a.row.totalWeight ? (r(), m("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: t[2] || (t[2] = (y) => k.value = true) }, b(i(q)(a.row.totalWeight, i(z).COM_WT__KG)), 1)) : (r(), m("span", xe, "-"))]), _: 1 }), d(e, { key: "closingDate", prop: "closingDate", label: "截止日", align: "center", "show-overflow-tooltip": true }, { default: s((a) => [x(b(a.row.closingDate ? i(P)(a.row.closingDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), d(e, { key: "constructionDay", prop: "constructionDay", label: "工期（天）", align: "center" }), d(e, { key: "line", prop: "line", label: "选择车间", align: "center", width: "290" }, { default: s((a) => {
      var y, R;
      return [h.value ? (r(), _(l, { key: 0, modelValue: a.row.line, "onUpdate:modelValue": (O) => a.row.line = O, options: V.value, props: J.value, filterable: "", clearable: "", "show-all-levels": "", placeholder: "请选择", onChange: (O) => ee(a.row.line, a.row), style: { width: "250px" }, disabled: !a.row.quantity }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "props", "onChange", "disabled"])) : (r(), m("span", Ne, b((y = a.row.workshop) != null && y.id ? a.row.workshop.name + ((R = a.row.productionLine) != null && R.id ? "/" + a.row.productionLine.name : "") : "-"), 1))];
    }), _: 1 }), d(e, { key: "endDate", prop: "endDate", label: "交货日期", align: "center", width: "250" }, { default: s((a) => [h.value ? (r(), _(c, { key: 0, modelValue: a.row.endDate, "onUpdate:modelValue": (y) => a.row.endDate = y, type: "date", "value-format": "x", placeholder: "请选择交货日期", disabled: !a.row.quantity, onChange: (y) => te(a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])) : (r(), m(re, { key: 1 }, [a.row.endDate ? (r(), m("span", Te, b(`${i(P)(a.row.endDate, "{y}-{m}-{d}")}`), 1)) : (r(), m("span", Be, "-"))], 64))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[g, F.value]])]), _: 1 }, 512), d(I, { "append-to-body": "", ref_key: "detailRef", ref: G, modelValue: k.value, "onUpdate:modelValue": t[3] || (t[3] = (a) => k.value = a), top: "10vh", "before-close": () => {
      k.value = false;
    }, title: "构零件清单", "wrapper-closable": false, "custom-class": "artifact-tree-drawer", size: "90%" }, { content: s(() => [d(i(Le), { drawerVisible: k.value, currentId: L.currentId }, null, 8, ["drawerVisible", "currentId"])]), _: 1 }, 8, ["modelValue", "before-close"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} };
export {
  He as default
};
