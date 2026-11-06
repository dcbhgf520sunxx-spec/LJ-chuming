import d from "axios";
import r from "qs";
import { ElMessage as n } from "element-plus";
import { ElMessageBox as i } from "element-plus";
import { X as t, b as s, j as l } from "../shared/runtime.js";
const o = d.create({ timeout: 1e4, headers: { "Content-Type": "application/json" }, cancelKey: true });
o.interceptors.request.use((e) => (t() && (e.headers.Authorization = t()), e.headers["Content-Type"] === "multipart/form-data" ? ((e.data === null || e.data === void 0) && (e.data = {}), (e.params === null || e.params === void 0) && (e.params = {})) : (s(e.data) && (e.data = {}), s(e.params) && (e.params = {})), e.headers["Content-Type"] === "application/x-www-form-urlencoded" && (e.data = r.stringify(e.data)), e.method === "get" && (e.paramsSerializer = (a) => r.stringify(a, { arrayFormat: "repeat" })), e), (e) => {
  console.log(e), Promise.reject(e);
});
o.interceptors.response.use((e) => {
  if (e.config.responseType === "blob" || e.config.responseType === "arraybuffer") return e;
  const a = e.data;
  if (a.code === 2e4) return a.data;
  switch (console.log(a.code, "res.coderes.coderes.coderes.coderes.coderes.code"), a.code) {
    case 40001:
    case 40002:
      i.confirm("你已被登出，可以取消继续留在该页面，或者重新登录", "确定登出", { confirmButtonText: "重新登录", cancelButtonText: "取消", type: "warning" }).then(() => {
        l.dispatch("user/logout"), location.reload();
      });
      break;
    default:
      n({ message: a.message, type: "error", duration: 5 * 1e3 });
  }
  return Promise.reject("error");
}, (e) => Promise.reject(e));
export {
  o as s
};
