import { ref as p } from "vue";
import { watch as U } from "vue";
import g from "moment";
import { openBlock as a } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as _ } from "vue";
import { unref as o } from "vue";
import { Fragment as f } from "vue";
import { renderList as y } from "vue";
import { withCtx as H } from "vue";
import { createBlock as v } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as L } from "vue";
import { ElImage as R } from "element-plus";
import { ElCard as A } from "element-plus";
import { _ as B, m as O, x as q, o as E, p as N, G as V, P as I, Y as z, Z as G, a as K } from "../../../../shared/runtime.js";
import { c as Q } from "../../../../modules/image-progress-49ea43fe.js";
import { p as Y } from "../../../../modules/project-19a12d6b.js";
import $ from "./module/header.vue.js";
const F = { class: "app-container" }, Z = { class: "head-container" }, J = ["max-height"], W = { style: { width: "100%", height: "60px", display: "flex", "flex-direction": "column", "justify-content": "space-evenly" } }, X = { key: 1, style: { color: "red", "margin-top": "20px" } }, ee = { __name: "index", setup(te) {
  const { globalProjectId: u, globalProject: ae } = O(["globalProjectId", "globalProject"]), k = { add: false, edit: false, del: false, download: false }, D = p(), j = p({}), C = p({}), b = p(false), h = p(false), { crud: s, CRUD: x } = q({ title: "形象进度", sort: [], permission: { ...Y }, optShow: { ...k }, requiredQuery: ["projectId"], crudApi: { ...Q }, hasPagination: true }, D), { maxHeight: P } = E({ wrapperBox: ".image-progress", paginate: true, extraHeight: 40 });
  U(() => u.value, (r) => {
    r && (s.query.projectId = u.value, s.toQuery());
  }, { immediate: true, deep: true });
  function M(r) {
    C.value = r;
  }
  function S() {
    j.value = {}, b.value = true;
  }
  async function T(r) {
    try {
      h.value = true, await z(G, r);
    } catch (c) {
      console.log("通用导出", c);
    } finally {
      h.value = false;
    }
  }
  return x.HOOK.beforeRefresh = () => (s.query.projectId = u.value || void 0, !!s.query.projectId), x.HOOK.handleRefresh = (r, c) => {
    const n = [], d = [], m = c.data.content;
    if (m.map((e) => {
      n.indexOf(g(e.createTime).format("YYYY-MM-DD")) < 0 && n.push(g(e.createTime).format("YYYY-MM-DD"));
    }), n.length) {
      for (let e = 0; e < n.length; e++) d.push({ createTime: n[e], imageList: m.filter((t) => g(t.createTime).format("YYYY-MM-DD") === n[e]) });
      d.map((e) => {
        e.imgSrc = [], e.imageList.length && e.imageList.map((t) => {
          e.imgSrc.push(t.imageUrl), t.imgSrc = [t.imageUrl];
        });
      });
    }
    c.data.content = d;
  }, (r, c) => {
    const n = R, d = K, m = A;
    return a(), i("div", F, [l("div", Z, [_(o($), { "project-id": o(u), onCurrentChange: M, onHandleUpload: S }, null, 8, ["project-id"])]), o(s).data.length ? (a(), i(f, { key: 0 }, [l("div", { "max-height": o(P) }, [(a(true), i(f, null, y(o(s).data, (e) => (a(), i("div", { key: e.createTime }, [(a(true), i(f, null, y(e.imageList, (t) => (a(), i("div", { key: t.id, style: { "margin-right": "20px", "text-align": "center", width: "377px", display: "inline-block", "margin-bottom": "10px" } }, [_(m, null, { default: H(() => [(a(), v(n, { style: { width: "100%", height: "251px" }, "preview-src-list": t.imgSrc, "initial-index": 1, key: t.id, src: t.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])), l("div", W, [l("div", null, [l("span", null, "上传日期：" + w(t.createTime ? o(N)(t.createTime, "{y}-{m}-{d}") : "-"), 1), o(V)(o(Y).download) ? (a(), v(d, { key: 0, "icon-class": "download", style: { "font-size": "16px", "margin-left": "3px" }, onClick: (oe) => T({ id: t.id }) }, null, 8, ["onClick"])) : L("", true)]), l("div", null, "上传人：" + w(t.createUserName), 1)])]), _: 2 }, 1024)]))), 128))]))), 128))], 8, J), _(o(I))], 64)) : (a(), i("div", X, "*暂无数据"))]);
  };
} }, ce = B(ee, [["__scopeId", "data-v-8a3d3d73"]]);
export {
  ce as default
};
