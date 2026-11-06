import { ref as k } from "vue";
import { computed as Q } from "vue";
import { provide as y } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as g } from "vue";
import { unref as e } from "vue";
import { withDirectives as W } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as h } from "vue";
import { withModifiers as P } from "vue";
import { ElMessageBox as J } from "element-plus";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElTag as Z } from "element-plus";
import { ElTooltip as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { a as oe } from "../../../../modules/common-f216149e.js";
import { l as w, _ as ae, x as ie, s8 as v, o as se, a3 as ne, cf as re, i as L, bV as C, G as T, P as le } from "../../../../shared/runtime.js";
import { P as ce } from "../../../../modules/base-6bc46ddf.js";
import de from "./module/form.vue.js";
import pe from "./module/header.vue.js";
import { u as ue } from "../../../../modules/use-process-af1f8c99.js";
function me(u) {
  return w({ module: "mes", url: "quota-config/coating/page", method: "get", params: u });
}
function fe(u) {
  return w({ module: "mes", url: "quota-config/coating", method: "post", data: u });
}
function ge(u) {
  return w({ module: "mes", url: "quota-config/coating", method: "put", data: u });
}
function F(u) {
  return w({ module: "mes", url: "quota-config/coating", method: "delete", params: u });
}
function he(u) {
  return w({ module: "mes", url: "productProcess/artifact-type-process-select", method: "get", params: u });
}
const _e = { get: me, add: fe, edit: ge, del: F };
const ye = { class: "app-container" }, be = { class: "head-container" }, we = { key: 0 }, ke = { key: 1 }, ve = { style: { padding: "0 10px", cursor: "pointer" } }, Ce = { key: 1 }, xe = { style: { padding: "0 10px", cursor: "pointer" } }, Pe = { key: 1 }, Le = { __name: "index", setup(u) {
  const N = { add: true, edit: false, del: false, download: false }, O = k(), { crud: c, columns: d, CRUD: D } = ie({ title: "涂装定额", permission: { ...v }, optShow: { ...N }, crudApi: { ..._e }, hasPagination: true }, O), A = k([]), z = k([]), { maxHeight: U } = se({ paginate: true }), { loaded: q, process: V } = ue(), M = Q(() => V.value.filter((o) => o.productType === ne.ARTIFACT.V && o.type === re.PAINT.V)), _ = k(false);
  async function R() {
    try {
      const o = await ce();
      _.value = o || false;
    } catch (o) {
      console.log("工价统计截止日", o);
    }
  }
  D.HOOK.handleRefresh = (o, m) => {
    R();
  };
  async function S(o) {
    try {
      await J.confirm(`确认将 ${o.serialNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await F({ id: o.id }), X.success("删除成功！"), c.refresh();
    } catch (m) {
      console.log(m);
    }
  }
  async function $() {
    try {
      const { content: o } = await oe();
      A.value = o || [];
    } catch (o) {
      console.log(o);
    }
  }
  async function j() {
    try {
      const { content: o } = await he({ mesProductEnum: 1 });
      z.value = o || [];
    } catch (o) {
      console.log(o);
    }
  }
  function H(o) {
    const copy = JSON.parse(JSON.stringify({
      branchCompanyIdList: o.branchCompanyIdList || [],
      workshopIdList: o.workshopIdList || [],
      artifactClassIdList: o.artifactClassIdList || [],
      processId: o.process?.id,
      measureUnit: o.measureUnit,
      paintFilmThicknessBase: o.paintFilmThicknessBase,
      startOrganizationInsidePrice: o.startOrganizationInsidePrice,
      startOrganizationOutsidePrice: o.startOrganizationOutsidePrice,
      startAddPaintFilmThickness: o.startAddPaintFilmThickness,
      startAddOrganizationInsidePrice: o.startAddOrganizationInsidePrice,
      startAddOrganizationOutsidePrice: o.startAddOrganizationOutsidePrice,
      conditionList: []
    }));
    c.resetForm(copy), c.toAdd();
  }
  return j(), $(), y("branchList", A), y("artifactTypeList", z), y("boolConfig", _), y("filterProcess", M), y("processLoaded", q), (o, m) => {
    const l = Y, I = Z, B = ee, x = E("common-button"), G = E("common-table"), K = te;
    return a(), b("div", ye, [f("div", be, [g(e(pe))]), W((a(), i(G, { ref_key: "tableRef", ref: O, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(U), showEmptySymbol: false, style: { width: "100%" } }, { default: s(() => [g(l, { type: "index", label: "序号", align: "center", width: "55", fixed: "left" }), e(d).visible("serialNumber") ? (a(), i(l, { key: "serialNumber", prop: "serialNumber", label: "定额编号", align: "center", fixed: "left" }, { default: s((t) => [f("span", null, p(t.row.serialNumber || "-"), 1)]), _: 1 })) : r("", true), e(d).visible("artifactClassList") ? (a(), i(l, { key: "artifactClassList", prop: "artifactClassList", "show-overflow-tooltip": true, label: "构件类型", align: "center" }, { default: s((t) => [e(L)(t.row.artifactClassList) ? (a(), b("span", we, p(t.row.artifactClassList.map((n) => n.name).join("、")), 1)) : (a(), b("span", ke, "-"))]), _: 1 })) : r("", true), e(d).visible("process") ? (a(), i(l, { key: "process", prop: "process", label: "生产方式", align: "center", fixed: "left" }, { default: s((t) => {
      var n;
      return [f("span", null, p(((n = t.row.process) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 })) : r("", true), e(d).visible("branchCompanyList") ? (a(), i(l, { key: "branchCompanyList", prop: "branchCompanyList", "show-overflow-tooltip": true, label: "适用机构", align: "center" }, { default: s((t) => [e(L)(t.row.branchCompanyList) ? (a(), i(B, { key: 0, content: t.row.branchCompanyList.map((n) => n.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [g(I, { round: "" }, { default: s(() => {
      var n;
      return [f("span", ve, p((n = t.row.branchCompanyList) == null ? void 0 : n.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (a(), b("span", Ce, "-"))]), _: 1 })) : r("", true), e(d).visible("workshopList") ? (a(), i(l, { key: "workshopList", prop: "workshopList", "show-overflow-tooltip": true, label: "适用车间", align: "center" }, { default: s((t) => [e(L)(t.row.workshopList) ? (a(), i(B, { key: 0, content: t.row.workshopList.map((n) => n.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [g(I, { round: "" }, { default: s(() => {
      var n;
      return [f("span", xe, p((n = t.row.workshopList) == null ? void 0 : n.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (a(), b("span", Pe, "-"))]), _: 1 })) : r("", true), e(d).visible("paintFilmThicknessBase") ? (a(), i(l, { key: "paintFilmThicknessBase", prop: "paintFilmThicknessBase", "show-overflow-tooltip": true, label: "漆膜厚度基数(µm)", align: "center", "min-width": "110px" }, { default: s((t) => [h(p(t.row.paintFilmThicknessBase ?? "-"), 1)]), _: 1 })) : r("", true), e(d).visible("startOrganizationInsidePrice") ? (a(), i(l, { key: "startOrganizationInsidePrice", prop: "startOrganizationInsidePrice", "show-overflow-tooltip": true, label: "起步编制内单价(元)", align: "center", "min-width": "120px" }, { default: s((t) => [h(p(e(C)(t.row.startOrganizationInsidePrice) ?? "-"), 1)]), _: 1 })) : r("", true), e(d).visible("startOrganizationOutsidePrice") ? (a(), i(l, { key: "startOrganizationOutsidePrice", prop: "startOrganizationOutsidePrice", "show-overflow-tooltip": true, label: "起步编制外单价(元)", align: "center", "min-width": "120px" }, { default: s((t) => [h(p(e(C)(t.row.startOrganizationOutsidePrice) ?? "-"), 1)]), _: 1 })) : r("", true), e(d).visible("startAddPaintFilmThickness") ? (a(), i(l, { key: "startAddPaintFilmThickness", prop: "startAddPaintFilmThickness", "show-overflow-tooltip": true, label: "起加漆膜厚度(µm)", align: "center", "min-width": "110px" }, { default: s((t) => [h(p(t.row.startAddPaintFilmThickness ?? "-"), 1)]), _: 1 })) : r("", true), e(d).visible("startAddOrganizationInsidePrice") ? (a(), i(l, { key: "startAddOrganizationInsidePrice", prop: "startAddOrganizationInsidePrice", "show-overflow-tooltip": true, label: "起加编制内单价(元)", align: "center", "min-width": "120px" }, { default: s((t) => [h(p(e(C)(t.row.startAddOrganizationInsidePrice) ?? "-"), 1)]), _: 1 })) : r("", true), e(d).visible("startAddOrganizationOutsidePrice") ? (a(), i(l, { key: "startAddOrganizationOutsidePrice", prop: "startAddOrganizationOutsidePrice", "show-overflow-tooltip": true, label: "起加编制外单价(元)", align: "center", "min-width": "120px" }, { default: s((t) => [h(p(e(C)(t.row.startAddOrganizationOutsidePrice) ?? "-"), 1)]), _: 1 })) : r("", true), e(d).visible("measureUnit") ? (a(), i(l, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", fixed: "right" }, { default: s((t) => [f("span", null, p(t.row.measureUnit || "-"), 1)]), _: 1 })) : r("", true), e(d).visible("operation") ? (a(), i(l, { key: 12, label: "操作", prop: "operation", align: "center", fixed: "right", "min-width": "180" }, { default: s((t) => [e(T)(e(v).add) ? (a(), i(x, { key: 0, icon: "el-icon-DocumentCopy", size: "default", type: "success", disabled: !_.value, onClick: P((n) => H(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : r("", true), e(T)(e(v).edit) ? (a(), i(x, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", disabled: !_.value, onClick: P((n) => e(c).toEdit(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : r("", true), e(T)(e(v).del) ? (a(), i(x, { key: 2, icon: "el-icon-delete", size: "default", type: "danger", disabled: !_.value, onClick: P((n) => S(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : r("", true)]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[K, e(c).loading]]), g(e(de)), g(e(le))]);
  };
} }, Fe = ae(Le, [["__scopeId", "data-v-eb501d97"]]);
export {
  Fe as default
};
