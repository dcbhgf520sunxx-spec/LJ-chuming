import { ref as h } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as o } from "vue";
import { unref as i } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as b } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as N } from "vue";
import { ElMessageBox as S } from "element-plus";
import { ElNotification as M } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { InfoFilled as I } from "@element-plus/icons-vue";
import { ElIcon as z } from "element-plus";
import { ElTooltip as H } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as L } from "../../../../modules/assembly-template-config-631cc212.js";
import F from "./module/header.vue.js";
import { _ as K, x as Q, fe as $, o as j, es as G, aw as J } from "../../../../shared/runtime.js";
const W = { class: "app-container" }, X = { class: "head-container" }, Y = { style: { display: "inline-block" } }, Z = { class: "board-item" }, ee = { class: "board-item" }, te = { __name: "index", setup(ae) {
  const w = h(), V = { add: false, edit: false, del: false, download: false }, { crud: u, columns: P, CRUD: k } = Q({ title: "板拼部件模板配置", permission: { ...$ }, crudApi: { ...L }, optShow: { ...V }, sort: [], dataPath: "", hasPagination: false }, w), { maxHeight: C } = j({ paginate: false }), T = h();
  k.HOOK.handleRefresh = (s, e) => {
    e.data = e.data.map((t) => {
      var r, p, x, f, _;
      return t.artifactPartNumberPrefixOptions = (r = t.artifactPartNumberPrefixList) == null ? void 0 : r.map((m) => ({ name: m })), t.webPartNumberPrefixListOptions = (p = t.webPartNumberPrefixList) == null ? void 0 : p.map((m) => ({ name: m })), t.sailPartNumberPrefixListOptions = (x = t.sailPartNumberPrefixList) == null ? void 0 : x.map((m) => ({ name: m })), t.webPartNumberPrefix = (f = t.webPartNumberPrefixList) == null ? void 0 : f[0], t.sailPartNumberPrefix = (_ = t.sailPartNumberPrefixList) == null ? void 0 : _[0], t;
    });
  };
  const E = { artifactPartNumberPrefixList: [{ validator: (s, e) => !((e.webPartNumberPrefix || e.sailPartNumberPrefix) && !e.artifactPartNumberPrefixList), message: "请输入构件定义类型", trigger: "change" }], PartNumberPrefixList: [{ validator: (s, e) => !((!e.webPartNumberPrefix || !e.sailPartNumberPrefix) && e.artifactPartNumberPrefixList), message: "请配置前缀默认翼腹板", trigger: "change" }] }, { tableValidate: O, wrongCellMask: R } = J({ rules: E });
  function U(s, e) {
    e && (s.artifactPartNumberPrefixOptions = e == null ? void 0 : e.map((t) => ({ name: t })));
  }
  function v() {
    const { validResult: s, dealList: e } = O(u.data);
    if (s) u.data = e;
    else return s;
    const t = u.data.map((r) => (r.webPartNumberPrefixList = r.webPartNumberPrefix ? [r.webPartNumberPrefix] : [], r.sailPartNumberPrefixList = r.sailPartNumberPrefix ? [r.sailPartNumberPrefix] : [], r));
    S.confirm("是否确认修改数据？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      await L.edit(t), M({ title: "修改成功！", type: "success", duration: 2500 }), u.toQuery();
    }).catch((r) => {
      console.log(r, "修改失败");
    });
  }
  return (s, e) => {
    const t = A, r = I, p = z, x = H, f = g("common-select"), _ = g("common-table"), m = q;
    return d(), B("div", W, [l("div", X, [o(i(F), { onToEdit: v })]), D((d(), b(_, { ref_key: "tableRef", ref: w, data: i(u).data, "empty-text": i(u).emptyText, "max-height": i(C), "return-source-data": "", "cell-class-name": i(R), "row-key": "id", style: { width: "100%" } }, { default: n(() => [o(t, { label: "序号", type: "index", align: "center", width: "60" }), i(P).visible("artifactType") ? (d(), b(t, { key: 0, prop: "artifactType", label: "类型", align: "center", width: "200" }, { default: n((a) => [l("span", null, y(i(G).VL[a.row.artifactType] || "-"), 1)]), _: 1 })) : N("", true), i(P).visible("structureClassificationName") ? (d(), b(t, { key: 1, prop: "structureClassificationName", label: "构件类型", align: "center", width: "300" }, { default: n((a) => [l("span", null, y(a.row.structureClassificationName), 1)]), _: 1 })) : N("", true), i(P).visible("artifactPartNumberPrefixList") ? (d(), b(t, { key: 2, prop: "artifactPartNumberPrefixList", label: "构件定义类型", align: "center", "min-width": "200px" }, { header: n(() => [o(x, { class: "item", effect: "light", content: "零件编号前缀/备注都具备时,自动默认为该构件类型,支持二次修改", placement: "top" }, { default: n(() => [l("div", Y, [e[0] || (e[0] = l("span", null, "所属零件编号前缀/备注定义", -1)), o(p, null, { default: n(() => [o(r)]), _: 1 })])]), _: 1 })]), default: n((a) => [o(f, { ref_key: "artifactPartNumberPrefixRef", ref: T, modelValue: a.row.artifactPartNumberPrefixList, "onUpdate:modelValue": (c) => a.row.artifactPartNumberPrefixList = c, options: a.row.artifactPartNumberPrefixOptions, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "请输入", "allow-create": "", filterable: "", multiple: "", clearable: "", style: { width: "350px" }, onChange: (c) => U(a.row, c) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 })) : N("", true), i(P).visible("PartNumberPrefixList") ? (d(), b(t, { key: 3, prop: "PartNumberPrefixList", label: "翼腹板识别属性配置", align: "center", "min-width": "200px" }, { default: n((a) => [l("div", Z, [e[1] || (e[1] = l("span", { class: "board-label" }, "腹板：", -1)), o(f, { modelValue: a.row.webPartNumberPrefix, "onUpdate:modelValue": (c) => a.row.webPartNumberPrefix = c, options: a.row.webPartNumberPrefixListOptions, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "请输入", "allow-create": "", filterable: "", clearable: "", style: { width: "250px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), l("div", ee, [e[2] || (e[2] = l("span", { class: "board-label" }, "翼板：", -1)), o(f, { modelValue: a.row.sailPartNumberPrefix, "onUpdate:modelValue": (c) => a.row.sailPartNumberPrefix = c, options: a.row.sailPartNumberPrefixListOptions, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "请输入", "allow-create": "", filterable: "", clearable: "", style: { width: "250px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])])]), _: 1 })) : N("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "cell-class-name"])), [[m, i(u).loading]])]);
  };
} }, ue = K(te, [["__scopeId", "data-v-58d9407c"]]);
export {
  ue as default
};
