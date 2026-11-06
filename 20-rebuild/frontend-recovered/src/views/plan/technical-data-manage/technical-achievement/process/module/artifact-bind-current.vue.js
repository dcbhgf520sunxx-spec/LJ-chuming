import { ref as f } from "vue";
import { inject as A } from "vue";
import { watch as D } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as w } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as j } from "vue";
import { unref as p } from "vue";
import { createCommentVNode as I } from "vue";
import { withDirectives as $ } from "vue";
import { withModifiers as C } from "vue";
import { createElementVNode as n } from "vue";
import { isRef as G } from "vue";
import { nextTick as K } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElTag as W } from "element-plus";
import { ElInput as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElForm as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { e as te } from "../../../../../../modules/process-611d795f.js";
import { _ as le, u as oe, o as ae, ts as re, z as se, q as ne } from "../../../../../../shared/runtime.js";
const ie = { style: { display: "flex" } }, de = { style: { margin: "10px 0" } }, ue = { style: { margin: "10px 0" } }, ce = { style: { "margin-bottom": "10px" } }, me = { style: { "margin-bottom": "10px" } }, pe = { style: { "margin-bottom": "10px" } }, fe = { style: { "margin-bottom": "10px" } }, ve = { style: { "text-align": "right" } }, be = { style: { flex: "1", "padding-left": "10px" } }, we = { __name: "artifact-bind-current", props: { modelValue: { type: Boolean, require: true }, showList: { type: Object, default: () => {
} }, projectId: { type: [Number, String], default: void 0 }, monomerId: { type: [Number, String], default: void 0 }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue", "delete"], setup(i, { emit: S }) {
  const m = i, t = f({}), k = f(), y = S, { visible: g, handleClose: N } = oe({ emit: y, props: m }), d = f([]), x = f(false), z = A("structureClassList"), R = f(), B = f([["project", "parse-project"]]);
  D(() => g.value, (r) => {
    if (r) {
      d.value = JSON.parse(JSON.stringify(m.showList));
      for (const e in t.value) t.value[e] = void 0;
      t.value.monomerId = m.projectId, t.value.monomerId = m.monomerId;
    }
  }, { deep: true, immediate: true });
  const { maxHeight: L } = ae({ mainBox: ".current-form", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, R);
  function O() {
    y("success"), N();
  }
  function V() {
    let r = JSON.parse(JSON.stringify(m.showList));
    const e = [];
    for (const a in t.value) t.value[a] && e.push(a);
    for (let a = 0; a < e.length; a++) e[a] === "monomerId" || e[a] === "structureClassId" || e[a] === "projectId" ? r = r.filter((c) => c[e[a]] === t.value[e[a]]) : r = r.filter((c) => c[e[a]].indexOf(t.value[e[a]]) > -1);
    d.value = r;
  }
  function U() {
    t.value = {}, K(() => {
      d.value = JSON.parse(JSON.stringify(m.showList));
    });
  }
  function E(r) {
    y("delete", d.value[r]), d.value.splice(r, 1);
  }
  async function J() {
    x.value = true;
    const r = [];
    d.value.forEach((e) => {
      r.push({ monomerId: e.monomerId, serialNumber: e.serialNumber });
    });
    try {
      await te({ processFileId: m.currentRow.id, details: r }), Q.success("绑定成功"), O();
    } catch (e) {
      console.log("绑定失败", e);
    } finally {
      x.value = false;
    }
  }
  return (r, e) => {
    const a = W, c = b("common-button"), T = b("project-cascader"), F = b("common-select"), h = X, u = Y, H = b("common-table"), q = Z, M = b("common-drawer"), P = ee;
    return w(), _(M, { "append-to-body": "", ref_key: "drawerRef", ref: R, modelValue: p(g), "onUpdate:modelValue": e[7] || (e[7] = (o) => G(g) ? g.value = o : null), top: "10vh", width: "600px", "before-close": p(N), title: `本次绑定列表：${i.currentRow.fileName}`, "wrapper-closable": false, size: "90%", "custom-class": "current-form" }, { titleAfter: s(() => [l(a, null, { default: s(() => [v("文件类型:" + j(p(re).VL[i.currentRow.processType]), 1)]), _: 1 }), i.currentRow.boolSingleProject ? (w(), _(a, { key: 0 }, { default: s(() => [v("所属项目:" + j(i.currentRow.project ? p(se)(i.currentRow.projectList[0]) : "-"), 1)]), _: 1 })) : I("", true)]), titleRight: s(() => [$((w(), _(c, { size: "default", type: "primary", onClick: C(J, ["stop"]), disabled: d.value.length === 0 }, { default: s(() => [v("提交（共" + j(d.value.length) + "条）", 1)]), _: 1 }, 8, ["disabled"])), [[P, x.value]])]), content: s(() => [l(q, { ref_key: "formRef", ref: k, size: "default", "label-width": "150px" }, { default: s(() => [n("div", ie, [n("div", null, [n("div", null, [i.currentRow.boolSingleProject ? I("", true) : (w(), _(T, { key: 0, modelValue: t.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (o) => t.value.projectId = o), clearable: "", class: "filter-item", style: { width: "270px" }, placeholder: "项目搜索" }, null, 8, ["modelValue"]))]), n("div", de, [l(p(ne), { ref: "monomerSelectRef", modelValue: t.value.monomerId, "onUpdate:modelValue": e[1] || (e[1] = (o) => t.value.monomerId = o), style: { width: "270px" }, default: false, clearable: "", "project-id": i.projectId, class: "filter-item", onChange: V }, null, 8, ["modelValue", "project-id"])]), n("div", ue, [l(F, { modelValue: t.value.structureClassId, "onUpdate:modelValue": e[2] || (e[2] = (o) => t.value.structureClassId = o), options: p(z), type: "other", clearable: "", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", style: { width: "270px" }, placeholder: "构件类型", onChange: V }, null, 8, ["modelValue", "options"])]), n("div", ce, [l(h, { modelValue: t.value.name, "onUpdate:modelValue": e[3] || (e[3] = (o) => t.value.name = o), placeholder: "构件名称搜索", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), n("div", me, [l(h, { modelValue: t.value.serialNumber, "onUpdate:modelValue": e[4] || (e[4] = (o) => t.value.serialNumber = o), placeholder: "构件编号", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), n("div", pe, [l(h, { modelValue: t.value.specification, "onUpdate:modelValue": e[5] || (e[5] = (o) => t.value.specification = o), placeholder: "构件规格", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), n("div", fe, [l(h, { modelValue: t.value.material, "onUpdate:modelValue": e[6] || (e[6] = (o) => t.value.material = o), placeholder: "构件材质", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), n("div", ve, [l(c, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: C(V, ["stop"]) }, { default: s(() => e[8] || (e[8] = [v("搜索")])), _: 1, __: [8] }), l(c, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh", onClick: C(U, ["stop"]) }, { default: s(() => e[9] || (e[9] = [v(" 重置 ")])), _: 1, __: [9] })])]), n("div", be, [l(H, { ref: "detailRef", border: "", data: d.value, "max-height": p(L) - 60, style: { width: "100%" }, class: "table-form", "data-format": B.value }, { default: s(() => [l(u, { label: "序号", type: "index", align: "center", width: "55" }), i.currentRow.boolSingleProject ? I("", true) : (w(), _(u, { key: 0, prop: "project", label: "项目", align: "left", "min-width": "150", "show-overflow-tooltip": "" })), l(u, { prop: "monomerName", label: "单体", align: "left", "show-overflow-tooltip": "" }), l(u, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), l(u, { prop: "name", label: "构件名称", align: "center", "show-overflow-tooltip": "" }), l(u, { prop: "structureClassName", label: "构件类型", align: "center", "show-overflow-tooltip": "" }), l(u, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), l(u, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "", width: "80" }), l(u, { label: "操作", align: "center", width: "80" }, { default: s((o) => [l(c, { size: "default", type: "danger", onClick: (_e) => E(o.$index) }, { default: s(() => e[10] || (e[10] = [v("移除")])), _: 2, __: [10] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])])])]), _: 1 }, 512)]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, xe = le(we, [["__scopeId", "data-v-6553bbd9"]]);
export {
  xe as default
};
