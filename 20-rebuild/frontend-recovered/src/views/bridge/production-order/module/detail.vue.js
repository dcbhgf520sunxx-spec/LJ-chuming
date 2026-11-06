import { ref as p } from "vue";
import { computed as ne } from "vue";
import { watch as M } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as r } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as s } from "vue";
import { unref as i } from "vue";
import { withDirectives as x } from "vue";
import { createTextVNode as j } from "vue";
import { createCommentVNode as U } from "vue";
import { createVNode as d } from "vue";
import { createElementVNode as re } from "vue";
import { toDisplayString as b } from "vue";
import { createElementBlock as m } from "vue";
import { Fragment as ie } from "vue";
import { isRef as se } from "vue";
import { ElMessage as de } from "element-plus";
import { ElMessageBox as ue } from "element-plus";
import { ElNotification as ce } from "element-plus";
import { ElTableColumn as pe } from "element-plus";
import { ElCascader as me } from "element-plus";
import { ElDatePicker as fe } from "element-plus";
import { ElForm as he } from "element-plus";
import { vLoading as we } from "element-plus";
import { s as ge, u as ye } from "../../../../modules/production-order-334bd558.js";
import { u as _e, o as be, F as ke, G as Ie, c3 as De, z as Ve, bV as q, D as z, p as P, aw as ve, i as $ } from "../../../../shared/runtime.js";
import { u as Le } from "../../../../modules/use-bridge-product-lines-0fd5db98.js";
import { j as A } from "../../../../modules/judgeSameValue-9683bdce.js";
import Ce from "./box-list.vue.js";
import "./type-detail.vue.js";
import "./components/Panel/index.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Se = { class: "project-name" }, xe = { key: 0 }, je = { key: 1 }, Ne = { key: 1 }, Te = { key: 1 }, Be = { key: 0 }, We = { key: 1 }, Fe = { __name: "detail", props: { currentId: { type: [String, Number], default: void 0 }, modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(L, { emit: F }) {
  const N = F, D = L, { visible: C, handleClose: T } = _e({ emit: N, props: D }), { productLines: B } = Le(), f = p(false), c = p([]), V = p([]), W = p(), H = p(false), h = p(false), E = p([]), G = p(), k = p(false), J = ne(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), { maxHeight: K } = be({ mainBox: ".schedule-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, minHeight: 300 }, () => W.value.loaded);
  M(B, (a) => {
    ee(B);
  }, { immediate: true, deep: true }), M(() => D.modelValue, (a) => {
    a && (h.value = false, ae());
  }, { deep: true, immediate: true });
  const X = { line: [{ validator: (a, t) => $(t.timeArr) ? !!$(a) : true, message: "请选择车间", trigger: "change" }] }, { tableValidate: Q, wrongCellMask: Y } = ve({ rules: X });
  function Z({ row: a, column: t, rowIndex: n, columnIndex: e }) {
    if (e === 0 || e === 1 || e === 5) return { rowspan: e === 0 || e === 5 ? a.projectSpan || 0 : a.monomerSpan || 0, colspan: 1 };
  }
  function ee(a) {
    V.value = [];
    const t = [];
    try {
      a && (JSON.parse(JSON.stringify(a.value)).map((e) => {
        e.disabled = true, e.workshopList.map((l) => {
          l.children = l.productionLineList.filter((u) => u.productType === ke.BOX.V) || [], t.push(l);
        }), e.children = e.workshopList || [];
      }), V.value = t);
    } catch (n) {
      console.log("获取工厂车间生产线树失败", n);
    }
  }
  function te(a, t) {
    if (a && a.length) {
      const n = V.value.find((e) => e.id === a[0]);
      t.factoryId = n.factoryId, t.workshopId = a[0], t.productionLineId = a[1] || void 0;
    } else t.factoryId = void 0, t.workshopId = void 0, t.productionLineId = void 0;
  }
  function oe(a) {
    a.endDate ? a.startDate = (/* @__PURE__ */ new Date()).getTime() : a.startDate = void 0;
  }
  async function ae() {
    if (c.value = [], !!D.currentId) try {
      const { content: a } = await ge({ projectId: D.currentId }), t = [];
      let n = 0;
      a.map((e) => {
        var l, u, w, v, I, g;
        n += e.totalNetWeight, e.line = [], e.projectId = (l = e.project) == null ? void 0 : l.id, e.monomerId = (u = e.monomer) == null ? void 0 : u.id, e.areaId = (w = e.area) == null ? void 0 : w.id, e.factoryId = (v = e.factory) == null ? void 0 : v.id, e.workshopId = (I = e.workshop) == null ? void 0 : I.id, e.productionLineId = (g = e.productionLine) == null ? void 0 : g.id, e.productionLineId ? e.line.push(e.workshopId, e.productionLineId) : e.workshopId && e.line.push(e.workshopId), t.indexOf(e.monomerId) < 0 && t.push(e.monomerId);
      });
      for (let e = 0; e < t.length; e++) {
        const l = a.filter((u) => u.monomerId === t[e]);
        l[0].monomerSpan = l.length, c.value.push(...l);
      }
      c.value[0].projectSpan = c.value.length, c.value[0].totalWeight = n, E.value = JSON.parse(JSON.stringify(c.value));
    } catch (a) {
      console.log("生产订单详情失败", a);
    }
  }
  async function le() {
    const { validResult: a, dealList: t } = Q(c.value);
    if (a) c.value = t;
    else return a;
    f.value = true;
    try {
      const n = [];
      let e = false;
      if (c.value.map((l) => {
        l.closingDate && l.endDate > l.closingDate && (e = true);
        const u = E.value.find((w) => w.areaId === l.areaId);
        (!A(u.endDate, l.endDate) || !A(u.line, l.line)) && n.push({ areaId: l.areaId, endDate: l.endDate || null, factoryId: l.factoryId || null, monomerId: l.monomerId, productionLineId: l.productionLineId || null, projectId: l.projectId, startDate: l.startDate || null, workshopId: l.workshopId || null });
      }), !n.length) {
        de.error("请至少提交或更改一条信息"), f.value = false;
        return;
      }
      e && await ue.confirm("排期计划大于项目主计划，是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ye(n), f.value = false, ce({ title: "提交成功", type: "success" }), N("success"), T();
    } catch (n) {
      f.value = false, console.log("生产订单排期", n);
    }
  }
  return (a, t) => {
    const n = S("common-button"), e = pe, l = me, u = fe, w = S("common-table"), v = he, I = S("common-drawer"), g = we;
    return r(), _(I, { ref_key: "drawerRef", ref: W, "append-to-body": "", "close-on-click-modal": false, "before-close": i(T), modelValue: i(C), "onUpdate:modelValue": t[4] || (t[4] = (o) => se(C) ? C.value = o : null), title: "计划排期", "wrapper-closable": false, size: "80%", "custom-class": "schedule-detail" }, { titleRight: s(() => [!h.value && i(Ie)(L.permission.edit) ? x((r(), _(n, { key: 0, size: "default", type: "warning", onClick: t[0] || (t[0] = (o) => h.value = true) }, { default: s(() => t[5] || (t[5] = [j("创建计划")])), _: 1, __: [5] })), [[g, f.value]]) : U("", true), h.value ? x((r(), _(n, { key: 1, size: "default", type: "primary", onClick: t[1] || (t[1] = (o) => le(i(De).PASS.V)) }, { default: s(() => t[6] || (t[6] = [j("提交")])), _: 1, __: [6] })), [[g, f.value]]) : U("", true)]), content: s(() => [d(v, { ref: "formRef", size: "default", "label-width": "130px" }, { default: s(() => [x((r(), _(w, { data: c.value, "return-source-data": "", showEmptySymbol: false, "span-method": Z, "max-height": i(K), "cell-class-name": i(Y), stripe: false }, { default: s(() => [d(e, { key: "project", prop: "project", label: "项目", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: s((o) => [re("span", Se, b(i(Ve)(o.row.project)), 1)]), _: 1 }), d(e, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true }), d(e, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true }), d(e, { key: "quantity", prop: "quantity", label: "数量（件）", align: "center", "show-overflow-tooltip": true }), d(e, { key: "totalNetWeight", prop: "totalNetWeight", label: "重量（kg）", align: "center", "show-overflow-tooltip": true }, { default: s((o) => [o.row.totalNetWeight ? (r(), m("span", xe, b(i(q)(o.row.totalNetWeight, i(z).COM_WT__KG)), 1)) : (r(), m("span", je, "-"))]), _: 1 }), d(e, { key: "totalWeight", prop: "totalWeight", label: "合计（kg）", align: "center", "show-overflow-tooltip": true }, { default: s((o) => [o.row.totalWeight ? (r(), m("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: t[2] || (t[2] = (y) => k.value = true) }, b(i(q)(o.row.totalWeight, i(z).COM_WT__KG)), 1)) : (r(), m("span", Ne, "-"))]), _: 1 }), d(e, { key: "closingDate", prop: "closingDate", label: "截止日", align: "center", "show-overflow-tooltip": true }, { default: s((o) => [j(b(o.row.closingDate ? i(P)(o.row.closingDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), d(e, { key: "constructionDay", prop: "constructionDay", label: "工期（天）", align: "center" }), d(e, { key: "line", prop: "line", label: "选择车间", align: "center", width: "290" }, { default: s((o) => {
      var y, O;
      return [h.value ? (r(), _(l, { key: 0, modelValue: o.row.line, "onUpdate:modelValue": (R) => o.row.line = R, options: V.value, props: J.value, filterable: "", clearable: "", "show-all-levels": "", placeholder: "请选择", onChange: (R) => te(o.row.line, o.row), style: { width: "250px" }, disabled: !o.row.quantity }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "props", "onChange", "disabled"])) : (r(), m("span", Te, b((y = o.row.workshop) != null && y.id ? o.row.workshop.name + ((O = o.row.productionLine) != null && O.id ? "/" + o.row.productionLine.name : "") : "-"), 1))];
    }), _: 1 }), d(e, { key: "timeArr", prop: "timeArr", label: "交货日期", align: "center", width: "250" }, { default: s((o) => [h.value ? (r(), _(u, { key: 0, modelValue: o.row.endDate, "onUpdate:modelValue": (y) => o.row.endDate = y, type: "date", "value-format": "x", placeholder: "请选择交货日期", disabled: !o.row.quantity, onChange: (y) => oe(o.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])) : (r(), m(ie, { key: 1 }, [o.row.endDate ? (r(), m("span", Be, b(`${i(P)(o.row.endDate, "{y}-{m}-{d}")}`), 1)) : (r(), m("span", We, "-"))], 64))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[g, H.value]])]), _: 1 }, 512), d(I, { "append-to-body": "", ref_key: "detailRef", ref: G, modelValue: k.value, "onUpdate:modelValue": t[3] || (t[3] = (o) => k.value = o), top: "10vh", "before-close": () => {
      k.value = false;
    }, title: "分段清单", "wrapper-closable": false, "custom-class": "artifact-tree-drawer", size: "90%" }, { content: s(() => [d(i(Ce), { drawerVisible: k.value, currentId: L.currentId }, null, 8, ["drawerVisible", "currentId"])]), _: 1 }, 8, ["modelValue", "before-close"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} };
export {
  Fe as default
};
