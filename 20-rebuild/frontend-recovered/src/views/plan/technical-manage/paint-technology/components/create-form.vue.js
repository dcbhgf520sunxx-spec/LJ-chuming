import { computed as h } from "vue";
import { ref as c } from "vue";
import { watch as j } from "vue";
import { nextTick as P } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as k } from "vue";
import { createBlock as L } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as F } from "vue";
import { toDisplayString as xe } from "vue";
import { createElementVNode as S } from "vue";
import { createElementBlock as Ee } from "vue";
import { withDirectives as je } from "vue";
import { createCommentVNode as ae } from "vue";
import { ElMessage as R } from "element-plus";
import { ElTag as Le } from "element-plus";
import { ElRadio as De } from "element-plus";
import { ElRadioGroup as Ae } from "element-plus";
import { ElFormItem as Pe } from "element-plus";
import { ElCol as Ue } from "element-plus";
import { ElInput as Se } from "element-plus";
import { ElRow as Re } from "element-plus";
import { ElForm as Be } from "element-plus";
import { ElCollapseItem as ze } from "element-plus";
import { ElCollapse as Me } from "element-plus";
import { ElTableColumn as Oe } from "element-plus";
import { vLoading as $e } from "element-plus";
import { l as y, _ as qe, mx as He, i as Ge, tM as ne, kb as Ke, bY as W, nP as Ye } from "../../../../../shared/runtime.js";
function Je(s) {
  return y({ url: "/api/tech/paintTechnology/page/list", method: "get", params: s });
}
function te(s) {
  return y({ url: "/api/tech/paintTechnology/save", method: "post", data: s });
}
function ie(s) {
  return y({ url: "/api/tech/paintTechnology/update", method: "put", data: s });
}
function Qe(s) {
  return y({ url: `/api/tech/paintTechnology/delete/${s}`, method: "delete" });
}
function We(s) {
  return y({ url: "/api/tech/paintTechnology/available/artifact/list", method: "get", params: s });
}
function le(s) {
  return y({ url: "/api/tech/paintTechnology/project/list", method: "get", params: s });
}
function oe(s) {
  return y({ url: "/api/tech/paintTechnology/related/artifact/list", method: "get", params: s });
}
function re(s) {
  return y({ url: "/api/mes/building/craft/paint-config/listAll", method: "get", cancelKey: false, params: s });
}
const pa = { get: Je, save: te, update: ie, delete: Qe, getAvailableArtifactList: We, getProjectSeriamber: le, getRelatedArtifactList: oe, getOptions: re };
const Xe = { class: "create-content" }, Ze = { class: "form-section" }, ea = { class: "paint-config-section" }, aa = { key: 0, class: "artifact-section" }, na = { class: "filter-bar" }, ta = { __name: "create-form", props: { modelValue: { type: Boolean, default: false }, formData: { type: Object, default: null }, artifactList: { type: Array, default: () => [] }, rangeType: { type: Number, default: void 0 }, projectId: { type: [Number, String], default: void 0 }, monomerId: { type: [Number, String], default: void 0 } }, emits: ["update:modelValue", "success", "artifact-removed"], setup(s, { emit: de }) {
  const u = s, B = de, z = h({ get: () => u.modelValue, set: (i) => B("update:modelValue", i) }), T = c(), _ = c(), M = c(false), O = c(false), X = c(["primer"]), x = c([]), E = c([]), $ = c([]), q = c([]), H = c([]), G = c([]), m = c({ monomerId: void 0, areaId: void 0, serialNumber: "" }), { projectsAll: ue } = He(), pe = h(() => {
    var n;
    const i = u.projectId || a.value.projectId, e = (n = ue.value) == null ? void 0 : n.find((r) => r.id === i);
    if (e) return e.serialNumber ? `${e.serialNumber}-${e.name}` : e.name;
    if (u.formData) {
      const r = u.formData.project;
      return `${r.serialNumber}-${r.name}`;
    }
    return "-";
  });
  function K() {
    return { id: void 0, processType: 1, serialNumber: "", historyProcessId: void 0, rangeType: 1, monomerId: u.monomerId, projectId: u.projectId, artifactIdList: [], paintConfig: { primer: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, intermediate: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, topcoat: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 } }, remark: "" };
  }
  const a = c(K()), se = h(() => a.value.processType === 2 ? {} : { paintConfigId: [{ required: true, message: "请选择油漆类型", trigger: "blur" }], paintColor: [{ required: true, message: "请输入油漆颜色", trigger: "blur" }] }), me = { processType: [{ required: true, message: "请选择工艺类型", trigger: "blur" }], serialNumber: [{ validator: (i, e, n) => {
    a.value.processType === 1 && !e ? n(new Error("请输入工艺编号")) : n();
  }, trigger: "blur" }], historyProcessId: [{ validator: (i, e, n) => {
    a.value.processType === 2 && !e ? n(new Error("请选择历史工艺")) : n();
  }, trigger: "blur" }] }, b = c([]), fe = h(() => {
    if (V.value) return b.value;
    let i = b.value;
    return m.value.monomerId && (i = i.filter((e) => e.monomer.id === m.value.monomerId)), m.value.areaId && (i = i.filter((e) => e.area.id === m.value.areaId)), m.value.serialNumber && (i = i.filter((e) => {
      var n;
      return (n = e.serialNumber) == null ? void 0 : n.includes(m.value.serialNumber);
    })), i;
  }), V = h(() => Ge(a.value.id)), ce = h(() => V.value ? b.value : fe.value), ge = h(() => {
    var e;
    return (((e = u.formData) == null ? void 0 : e.rangeTypeEnum) ?? a.value.rangeType) === ne.MANUAL.V;
  });
  function ve(i) {
    i === 2 && (a.value.paintConfig = { primer: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, intermediate: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, topcoat: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 } }, Z());
  }
  function be(i) {
    if (!i) {
      a.value.paintConfig = { primer: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, intermediate: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, topcoat: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 } };
      return;
    }
    const e = x.value.find((r) => r.id === i);
    if (!e || !e.paintTechnologyDetailList) return;
    const n = e.paintTechnologyDetailList;
    a.value.paintConfig = { primer: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, intermediate: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 }, topcoat: { paintConfigId: void 0, brandId: void 0, brandName: "", paintColor: "", paintFilmThickness: 0 } }, n.forEach((r) => {
      let d = "";
      r.paintingTypeEnum === W.PRIMER.V ? d = "primer" : r.paintingTypeEnum === W.INTERMEDIATE_PAINT.V ? d = "intermediate" : r.paintingTypeEnum === W.TOPCOAT.V && (d = "topcoat"), d && (a.value.paintConfig[d] = { paintConfigId: r.paintConfigId, brandId: void 0, brandName: r.paintBrand, paintColor: r.paintColor, paintFilmThickness: r.paintFilmThickness });
    });
  }
  async function Z() {
    if (!(!u.projectId && !u.formData.projectId)) try {
      const i = await le({ projectId: u.projectId || u.formData.projectId });
      x.value = i.content || [];
    } catch (i) {
      console.log("获取历史工艺编号失败", i), x.value = [];
    }
  }
  async function Ce() {
    if (!(!u.projectId && !u.formData.projectId)) try {
      const i = await Ye(u.projectId || u.formData.projectId);
      E.value = ((i == null ? void 0 : i.content) || []).map((e) => ({ id: e.id, name: e.name, areas: e.areaSimpleList || [] })), ee();
    } catch (i) {
      console.log("获取单体列表失败", i), E.value = [];
    }
  }
  function ee() {
    if (a.value.monomerId) {
      const i = E.value.find((e) => e.id === a.value.monomerId);
      $.value = ((i == null ? void 0 : i.areas) || []).map((e) => ({ id: e.id, name: e.name }));
    } else {
      const i = [];
      E.value.forEach((e) => {
        e.areas && i.push(...e.areas.map((n) => ({ id: n.id, name: n.name })));
      }), $.value = i;
    }
  }
  function Ie() {
    Y();
  }
  function ye() {
    m.value = { monomerId: void 0, areaId: void 0, serialNumber: "" }, Y();
  }
  function he(i) {
    const e = b.value.findIndex((n) => n.artifactId === i.artifactId);
    e > -1 && (b.value.splice(e, 1), B("artifact-removed", i.artifactId), R.success("已移除"));
  }
  async function Te() {
    if (!(!T.value || !_.value)) try {
      if (await T.value.validate(), await _.value.validate(), !_e()) return;
      const i = a.value.processType === 2 ? a.value.historyProcessId : a.value.id;
      let e = a.value.serialNumber;
      if (a.value.processType === 2) {
        const d = x.value.find((g) => g.id === a.value.historyProcessId);
        d && (e = d.serialNumber);
      }
      const n = { id: i, projectId: u.projectId || a.value.projectId, serialNumber: e, rangeTypeEnum: a.value.rangeType, monomerId: a.value.monomerId || u.monomerId, artifactIdList: b.value.map((d) => d.artifactId), paintTechnologyDetailList: [], remark: a.value.remark }, r = [];
      a.value.paintConfig.primer.paintConfigId && r.push({ paintConfigId: a.value.paintConfig.primer.paintConfigId, paintColor: a.value.paintConfig.primer.paintColor || "", paintFilmThickness: a.value.paintConfig.primer.paintFilmThickness || 0, paintingTypeEnum: 1 }), a.value.paintConfig.intermediate.paintConfigId && r.push({ paintConfigId: a.value.paintConfig.intermediate.paintConfigId, paintColor: a.value.paintConfig.intermediate.paintColor || "", paintFilmThickness: a.value.paintConfig.intermediate.paintFilmThickness || 0, paintingTypeEnum: 2 }), a.value.paintConfig.topcoat.paintConfigId && r.push({ paintConfigId: a.value.paintConfig.topcoat.paintConfigId, paintColor: a.value.paintConfig.topcoat.paintColor || "", paintFilmThickness: a.value.paintConfig.topcoat.paintFilmThickness || 0, paintingTypeEnum: 4 }), n.paintTechnologyDetailList = r, M.value = true;
      try {
        V.value ? (await ie(n), R.success("更新成功")) : (await te(n), R.success("创建成功")), B("success");
      } catch (d) {
        console.log("保存失败", d);
      } finally {
        M.value = false;
      }
    } catch (i) {
      console.log("表单验证失败", i);
    }
  }
  function _e() {
    if (a.value.processType !== 1) return true;
    const i = [], e = (n, r) => {
      ((n == null ? void 0 : n.paintConfigId) != null || (n == null ? void 0 : n.paintColor) && String(n.paintColor).trim() !== "" || Number(n == null ? void 0 : n.paintFilmThickness) > 0) && ((n == null ? void 0 : n.paintConfigId) != null && String((n == null ? void 0 : n.paintColor) || "").trim() !== "" || i.push(r));
    };
    return e(a.value.paintConfig.intermediate, "中间漆"), e(a.value.paintConfig.topcoat, "面漆"), i.length ? (R.error(i.join("、") + "需选择油漆类型和颜色"), false) : true;
  }
  async function Ve() {
    u.formData ? (a.value = { ...a.value, ...u.formData }, u.formData.id && await we(u.formData.id)) : (a.value.rangeType = u.rangeType || 1, b.value = [...u.artifactList || []]);
  }
  async function we(i) {
    try {
      const e = u.formData || {};
      await Promise.all([w(1), w(2), w(4)]), a.value.id = e.id, a.value.serialNumber = e.serialNumber, a.value.rangeType = e.rangeTypeEnum || ne.MANUAL.V, a.value.monomerId = e.monomerId || u.monomerId, a.value.projectId = e.projectId || u.projectId, a.value.remark = e.remark || "", e.paintTechnologyDetailList && e.paintTechnologyDetailList.forEach((n) => {
        n.paintingTypeEnum === 1 ? a.value.paintConfig.primer = { paintConfigId: n.paintConfigId != null ? Number(n.paintConfigId) : void 0, brandId: n.brandId, brandName: n.brandName || n.paintBrand || "", paintColor: n.paintColor || "", paintFilmThickness: n.paintFilmThickness || 0 } : n.paintingTypeEnum === 2 ? a.value.paintConfig.intermediate = { paintConfigId: n.paintConfigId != null ? Number(n.paintConfigId) : void 0, brandId: n.brandId, brandName: n.brandName || n.paintBrand || "", paintColor: n.paintColor || "", paintFilmThickness: n.paintFilmThickness || 0 } : n.paintingTypeEnum === 4 && (a.value.paintConfig.topcoat = { paintConfigId: n.paintConfigId != null ? Number(n.paintConfigId) : void 0, brandId: n.brandId, brandName: n.brandName || n.paintBrand || "", paintColor: n.paintColor || "", paintFilmThickness: n.paintFilmThickness || 0 });
      }), await P(), v(1), v(2), v(4), await Y();
    } catch (e) {
      console.log("加载详情失败", e);
    }
  }
  async function Y() {
    if (V.value) {
      O.value = true;
      try {
        const i = { projectId: u.projectId || a.value.projectId, paintTechnologyId: a.value.id, monomerId: m.value.monomerId, areaId: m.value.areaId, serialNumber: m.value.serialNumber }, e = await oe(i);
        b.value = (e == null ? void 0 : e.content) || [];
      } catch (i) {
        console.log("获取已关联构件失败", i), b.value = [];
      } finally {
        O.value = false;
      }
    }
  }
  async function w(i) {
    if (![1, 2, 4].includes(i)) return;
    const e = await re({ paintingTypeEnum: i }), r = { 1: q, 2: H, 4: G }[i];
    r && (r.value = ((e == null ? void 0 : e.content) || []).map((d) => ({ ...d, paintConfigId: d.paintConfigId != null ? Number(d.paintConfigId) : d.paintConfigId })), v(i));
  }
  function v(i) {
    const e = { 1: q.value, 2: H.value, 4: G.value }, n = { 1: a.value.paintConfig.primer, 2: a.value.paintConfig.intermediate, 4: a.value.paintConfig.topcoat }, r = e[i] || [], d = n[i];
    if (!d) return;
    const g = r.find((p) => p.paintConfigId === d.paintConfigId);
    g ? (d.brandId = g.brandId || g.paintBrandId, d.brandName = g.paintBrand || "") : (d.brandId = void 0, d.brandName = "");
  }
  return j(() => z.value, async (i) => {
    var e, n, r, d, g, p;
    if (i) {
      a.value = K(), await P(), (e = T.value) == null || e.clearValidate(), (n = _.value) == null || n.clearValidate(), await Ve(), (u.projectId || u.formData.projectId) && (Ce(), a.value.processType === 2 && Z());
      try {
        await Promise.all([w(1), w(2), w(4)]), await P(), v(1), v(2), v(4);
      } catch (f) {
        console.log("获取油漆配置失败", f);
      }
      await P(), (r = T.value) == null || r.clearValidate(), (d = _.value) == null || d.clearValidate();
    } else (g = T.value) == null || g.clearValidate(), (p = _.value) == null || p.clearValidate(), a.value = K();
  }), j(() => a.value.monomerId, () => {
    ee();
  }), j(() => a.value.paintConfig.primer.paintConfigId, () => v(1)), j(() => a.value.paintConfig.intermediate.paintConfigId, () => v(2)), j(() => a.value.paintConfig.topcoat.paintConfigId, () => v(4)), (i, e) => {
    const n = Le, r = U("common-button"), d = De, g = Ae, p = Pe, f = Ue, I = Se, N = U("common-select"), D = Re, A = Be, J = U("common-input-number"), Q = ze, Ne = Me, C = Oe, ke = U("common-table"), Fe = $e;
    return k(), L(Ke, { ref: "drawerRef", modelValue: z.value, "onUpdate:modelValue": e[19] || (e[19] = (o) => z.value = o), title: s.formData ? "编辑工艺" : "创建工艺", "show-close": true, "wrapper-closable": false, size: "100%", "custom-class": "paint-technology-create-drawer" }, { titleAfter: l(() => [t(n, null, { default: l(() => [F("项目：" + xe(pe.value), 1)]), _: 1 })]), titleRight: l(() => [t(r, { type: "primary", size: "default", loading: M.value, onClick: Te, style: { "margin-left": "10px" } }, { default: l(() => e[20] || (e[20] = [F(" 保存 ")])), _: 1, __: [20] }, 8, ["loading"])]), content: l(() => [S("div", Xe, [S("div", Ze, [t(A, { ref_key: "formRef", ref: T, model: a.value, rules: me, "label-width": "120px", size: "default" }, { default: l(() => [t(D, { gutter: 20 }, { default: l(() => [t(f, { span: 12 }, { default: l(() => [t(p, { label: "选择:", prop: "processType" }, { default: l(() => [t(g, { modelValue: a.value.processType, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value.processType = o), onChange: ve }, { default: l(() => [t(d, { label: 1 }, { default: l(() => e[21] || (e[21] = [F("新工艺")])), _: 1, __: [21] }), t(d, { label: 2, disabled: a.value.rangeType !== 1 || V.value }, { default: l(() => e[22] || (e[22] = [F("历史工艺")])), _: 1, __: [22] }, 8, ["disabled"])]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(f, { span: 12 }, { default: l(() => [a.value.processType === 1 ? (k(), L(p, { key: 0, label: "工艺编号:", prop: "serialNumber" }, { default: l(() => [t(I, { modelValue: a.value.serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (o) => a.value.serialNumber = o), placeholder: "请输入工艺编号", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 })) : (k(), L(p, { key: 1, label: "工艺编号:", prop: "historyProcessId" }, { default: l(() => [t(N, { modelValue: a.value.historyProcessId, "onUpdate:modelValue": e[2] || (e[2] = (o) => a.value.historyProcessId = o), options: x.value, dataStructure: { key: "id", label: "serialNumber", value: "id" }, clearable: "", placeholder: "选择历史工艺", style: { width: "100%" }, onChange: be }, null, 8, ["modelValue", "options"])]), _: 1 }))]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])]), S("div", ea, [t(Ne, { modelValue: X.value, "onUpdate:modelValue": e[15] || (e[15] = (o) => X.value = o) }, { default: l(() => [t(Q, { name: "primer", title: "底漆" }, { default: l(() => [t(A, { ref_key: "formPrimerRef", ref: _, model: a.value.paintConfig.primer, "label-width": "120px", rules: se.value, size: "default", disabled: a.value.processType === 2 }, { default: l(() => [t(D, { gutter: 20 }, { default: l(() => [t(f, { span: 6 }, { default: l(() => [t(p, { label: "油漆类型:", prop: "paintConfigId" }, { default: l(() => [t(N, { modelValue: a.value.paintConfig.primer.paintConfigId, "onUpdate:modelValue": e[3] || (e[3] = (o) => a.value.paintConfig.primer.paintConfigId = o), options: q.value, dataStructure: { key: "paintConfigId", label: "paintType", value: "paintConfigId" }, clearable: "", placeholder: "选择", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "品牌:", prop: "brandName" }, { default: l(() => [t(I, { modelValue: a.value.paintConfig.primer.brandName, "onUpdate:modelValue": e[4] || (e[4] = (o) => a.value.paintConfig.primer.brandName = o), placeholder: "请选择油漆类型后自动带出品牌", style: { width: "100%" }, disabled: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "颜色:", prop: "paintColor" }, { default: l(() => [t(I, { modelValue: a.value.paintConfig.primer.paintColor, "onUpdate:modelValue": e[5] || (e[5] = (o) => a.value.paintConfig.primer.paintColor = o), placeholder: "输入油漆颜色", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "漆膜厚度:", prop: "paintFilmThickness" }, { default: l(() => [t(J, { modelValue: a.value.paintConfig.primer.paintFilmThickness, "onUpdate:modelValue": e[6] || (e[6] = (o) => a.value.paintConfig.primer.paintFilmThickness = o), min: 0, max: 9999, precision: 0, placeholder: "漆膜厚度", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules", "disabled"])]), _: 1 }), t(Q, { name: "intermediate", title: "中间漆" }, { default: l(() => [t(A, { model: a.value.paintConfig.intermediate, "label-width": "120px", size: "default", disabled: a.value.processType === 2 }, { default: l(() => [t(D, { gutter: 20 }, { default: l(() => [t(f, { span: 6 }, { default: l(() => [t(p, { label: "油漆类型:" }, { default: l(() => [t(N, { modelValue: a.value.paintConfig.intermediate.paintConfigId, "onUpdate:modelValue": e[7] || (e[7] = (o) => a.value.paintConfig.intermediate.paintConfigId = o), options: H.value, dataStructure: { key: "paintConfigId", label: "paintType", value: "paintConfigId" }, clearable: "", placeholder: "选择", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "品牌:" }, { default: l(() => [t(I, { modelValue: a.value.paintConfig.intermediate.brandName, "onUpdate:modelValue": e[8] || (e[8] = (o) => a.value.paintConfig.intermediate.brandName = o), placeholder: "请选择油漆类型后自动带出品牌", style: { width: "100%" }, disabled: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "颜色:" }, { default: l(() => [t(I, { modelValue: a.value.paintConfig.intermediate.paintColor, "onUpdate:modelValue": e[9] || (e[9] = (o) => a.value.paintConfig.intermediate.paintColor = o), placeholder: "输入油漆颜色", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "漆膜厚度:" }, { default: l(() => [t(J, { modelValue: a.value.paintConfig.intermediate.paintFilmThickness, "onUpdate:modelValue": e[10] || (e[10] = (o) => a.value.paintConfig.intermediate.paintFilmThickness = o), min: 0, max: 9999, precision: 0, placeholder: "漆膜厚度", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }), t(Q, { name: "topcoat", title: "面漆" }, { default: l(() => [t(A, { model: a.value.paintConfig.topcoat, "label-width": "120px", size: "default", disabled: a.value.processType === 2 }, { default: l(() => [t(D, { gutter: 20 }, { default: l(() => [t(f, { span: 6 }, { default: l(() => [t(p, { label: "油漆类型:" }, { default: l(() => [t(N, { modelValue: a.value.paintConfig.topcoat.paintConfigId, "onUpdate:modelValue": e[11] || (e[11] = (o) => a.value.paintConfig.topcoat.paintConfigId = o), options: G.value, dataStructure: { key: "paintConfigId", label: "paintType", value: "paintConfigId" }, clearable: "", placeholder: "选择", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "品牌:" }, { default: l(() => [t(I, { modelValue: a.value.paintConfig.topcoat.brandName, "onUpdate:modelValue": e[12] || (e[12] = (o) => a.value.paintConfig.topcoat.brandName = o), placeholder: "请选择油漆类型后自动带出品牌", style: { width: "100%" }, disabled: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "颜色:" }, { default: l(() => [t(I, { modelValue: a.value.paintConfig.topcoat.paintColor, "onUpdate:modelValue": e[13] || (e[13] = (o) => a.value.paintConfig.topcoat.paintColor = o), placeholder: "输入油漆颜色", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(f, { span: 6 }, { default: l(() => [t(p, { label: "漆膜厚度:" }, { default: l(() => [t(J, { modelValue: a.value.paintConfig.topcoat.paintFilmThickness, "onUpdate:modelValue": e[14] || (e[14] = (o) => a.value.paintConfig.topcoat.paintFilmThickness = o), min: 0, max: 9999, precision: 0, placeholder: "漆膜厚度", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])]), _: 1 })]), _: 1 }, 8, ["modelValue"])]), a.value.rangeType === 1 || V.value ? (k(), Ee("div", aa, [S("div", na, [t(N, { modelValue: m.value.monomerId, "onUpdate:modelValue": e[16] || (e[16] = (o) => m.value.monomerId = o), options: E.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", placeholder: "全部单体", style: { width: "150px", "margin-right": "10px" } }, null, 8, ["modelValue", "options"]), t(N, { modelValue: m.value.areaId, "onUpdate:modelValue": e[17] || (e[17] = (o) => m.value.areaId = o), options: $.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", placeholder: "全部区域", style: { width: "150px", "margin-right": "10px" } }, null, 8, ["modelValue", "options"]), t(I, { modelValue: m.value.serialNumber, "onUpdate:modelValue": e[18] || (e[18] = (o) => m.value.serialNumber = o), placeholder: "编号搜索", style: { width: "200px", "margin-right": "10px" }, clearable: "" }, null, 8, ["modelValue"]), t(r, { type: "primary", size: "default", onClick: Ie }, { default: l(() => e[23] || (e[23] = [F("搜索")])), _: 1, __: [23] }), t(r, { size: "default", onClick: ye }, { default: l(() => e[24] || (e[24] = [F("重置")])), _: 1, __: [24] })]), je((k(), L(ke, { ref: "artifactTableRef", data: ce.value, "return-source-data": "", style: { width: "100%" } }, { default: l(() => [t(C, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(C, { prop: "monomer.name", label: "单体", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(C, { prop: "area.name", label: "区域", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(C, { prop: "name", label: "名称", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(C, { prop: "serialNumber", label: "编号", align: "center", "min-width": "140px", "show-overflow-tooltip": true }), t(C, { prop: "specification", label: "规格", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(C, { prop: "quantity", label: "数量", align: "center", "min-width": "80px" }), t(C, { prop: "totalArea", label: "面积", align: "center", "min-width": "80px" }), ge.value ? (k(), L(C, { key: 0, label: "操作", align: "center", width: "100px", fixed: "right" }, { default: l((o) => [t(r, { type: "danger", size: "default", icon: "el-icon-delete", onClick: (la) => he(o.row) }, null, 8, ["onClick"])]), _: 1 })) : ae("", true)]), _: 1 }, 8, ["data"])), [[Fe, O.value]])])) : ae("", true)])]), _: 1 }, 8, ["modelValue", "title"]);
  };
} }, ia = qe(ta, [["__scopeId", "data-v-2c5a3e84"]]), sa = Object.freeze(Object.defineProperty({ __proto__: null, default: ia }, Symbol.toStringTag, { value: "Module" }));
export {
  pa as a,
  sa as b,
  ia as c,
  We as g
};
